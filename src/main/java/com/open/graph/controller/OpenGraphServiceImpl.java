package com.open.graph.controller;

import com.open.graph.common.OpenGraphMetaDataProperties;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.client.WebClient;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Pratyay Ganguli
 */

public class OpenGraphServiceImpl implements OpenGraphService{
    private final WebClient client = WebClient.create(Vertx.vertx());
    @Override
    public Future<Void> fetchMetadata(String url) {
        return Future.future(promise->{
            client
                    .getAbs(url)
                    .send()
                    .compose(bufferResponse->{
                       var bodyAsString = bufferResponse.bodyAsString();
                       System.out.println(bodyAsString);
                       return Future.succeededFuture();
                    });
        });
    }

    public Future<Void> parseMeta(String url){
        return Future.future(promise->{
            var ogData = new HashMap<String, String>();
            try {
                var document = Jsoup.connect(url).get();
                var elements = document.select("meta");
                if(elements.isEmpty()) {
                    promise.complete();
                }
                else{
                    for (var element : elements) {
                        var attributes = element.attributes();
                        if (OpenGraphMetaDataProperties.isValidProperty(attributes.get("property"))) {
                            ogData.put(attributes.get("property"), attributes.get("content"));
                        }
                    }
                    var metadataJson = Json.encode(ogData);
                    System.out.println(metadataJson);
                    promise.complete();
                }
            }
            catch (IOException e){
                throw new RuntimeException("Could not fetch contents of the URL");
            }
        });
    }
}
