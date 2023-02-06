package com.open.graph.controller;

import com.open.graph.common.OpenGraphMetaData;
import com.open.graph.exceptions.OpenGraphException;
import io.vertx.core.Future;
import org.jsoup.Jsoup;
import java.io.IOException;

/**
 * @author Pratyay Ganguli
 */

public class OpenGraphServiceImpl implements OpenGraphService{
    @Override
    public Future<OpenGraphMetaData> fetchMetadata(String url) {
        return Future.future(promise->{
            try{
                var document = Jsoup.connect(url).get();
                var elements = document.getElementsByTag("meta");

            }
            catch(IOException e){
                throw new OpenGraphException("Cannot connect to this URL");
            }
        });
    }
}
