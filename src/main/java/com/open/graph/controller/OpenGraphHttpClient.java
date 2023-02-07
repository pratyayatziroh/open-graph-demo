package com.open.graph.controller;

import io.vertx.core.Future;
import java.net.http.HttpClient;

/**
 * @author Pratyay Ganguli
 */

public class OpenGraphHttpClient {
    private final HttpClient httpClient;
    public OpenGraphHttpClient() {
        httpClient = HttpClient.newHttpClient();
    }
    public Future<Void> send(){
        return Future.future(promise->{

        });
    }
}
