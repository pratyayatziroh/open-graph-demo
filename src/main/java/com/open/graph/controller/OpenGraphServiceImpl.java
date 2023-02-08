package com.open.graph.controller;

import com.open.graph.common.OpenGraphMetaDataProperties;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.HashMap;

/**
 * @author Pratyay Ganguli
 */

public class OpenGraphServiceImpl implements OpenGraphService{
    private final WebClientOptions webClientOptions;

    public OpenGraphServiceImpl(){
        webClientOptions = new WebClientOptions();
        webClientOptions.setUserAgent("PostmanRuntime/7.30.0");
        webClientOptions.setKeepAlive(true);
    }

    @Override
    public Future<String> fetchMetadata(String url) {
        return Future.future(promise->{
            final WebClient client = WebClient.create(Vertx.vertx(), webClientOptions);
            var ogData = new HashMap<String, String>();
            client
                    .getAbs(url)
                    .send()
                    .onSuccess(bufferResponse->{
                        var bodyAsString = bufferResponse.bodyAsString();
                        Document document = Jsoup.parse(bodyAsString);
                        var head = document.select("head").first();
                        var childElements =  head.children();
                        if(childElements.isEmpty()) {
                            promise.complete();
                        }

                        else{
                            for (var element : childElements) {
                                var attributes = element.attributes();
                                if (OpenGraphMetaDataProperties.isValidProperty(attributes.get("property"))) {
                                    ogData.put(attributes.get("property"), attributes.get("content"));
                                }
                            }
                            var metadataJson = Json.encode(ogData);
                            promise.complete(metadataJson);
                        }
                    });
        });
    }
}
