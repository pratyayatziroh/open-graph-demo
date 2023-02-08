package com.open.graph.controller;

import com.open.graph.controller.HeadMetaDataServiceImpl;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Pratyay Ganguli
 */

@ExtendWith(VertxExtension.class)

class HeadMetaDataServiceImplTest {
    private final HeadMetaDataServiceImpl service;

    public HeadMetaDataServiceImplTest(){
        service = new HeadMetaDataServiceImpl();
    }


    @Test
    public void getData(VertxTestContext context){
        var url = "https://www.flipkart.com";
        service
                .getData(url)
                .onComplete(context.succeeding(buffer->{
                    context.verify(()->{
                        context.completeNow();
                    });
                }));
    }

}
