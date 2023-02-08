package com.open.graph.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * @author Pratyay Ganguli
 */

public class OKHttpMetadata {
    private final OkHttpClient client;
    public OKHttpMetadata(){
        client = new OkHttpClient();
    }

    public void getData() {
        try {
            var request = new Request
                    .Builder()
                    .get()
                    .addHeader("Accept", "*/*")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                    .url("https://www.rapido.bike")
                    .build();
            var call = client.newCall(request);
            Response response = call.execute();
            var bodyAsString = response.body().string();
            System.out.println(bodyAsString);

        } catch (IOException e) {
            throw new RuntimeException("");
        }
    }
}
