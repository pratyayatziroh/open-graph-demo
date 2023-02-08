package com.open.graph.controller;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;

import java.io.IOException;

/**
 * @author Pratyay Ganguli
 */

public class HeadMetaDataServiceImpl {
    private final HttpConnection connection;
    public HeadMetaDataServiceImpl() {
        connection = new HttpConnection();
    }

    public Future<Void> getData(String url) {
        return Future.future(promise->{
            try {
                connection.url(url);
                connection.header("Accept", "text/html");
                connection.header("Content-Type", "text/html");
                connection.header("Accept-Encoding", "gzip, deflate, br");
                connection.header("User-Agent", "PostmanRuntime/7.30.1");
                var document = connection.get();
                document.head();
                promise.complete();
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }
        });
    }
}
