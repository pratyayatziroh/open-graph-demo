package com.open.graph.controller;

import io.vertx.core.impl.future.SucceededFuture;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

/**
 * @author Pratyay Ganguli
 */

public class OkHttpMetadataTest {
    @Test
    public void getData(){
        var okHttp = new OKHttpMetadata();
        okHttp.getData();
    }
}
