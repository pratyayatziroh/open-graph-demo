package com.open.graph.controller;

import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Pratyay Ganguli
 */

@ExtendWith(VertxExtension.class)

class OpenGraphServiceImplTest {
    private final OpenGraphServiceImpl openGraphService;
    OpenGraphServiceImplTest() {
        openGraphService = new OpenGraphServiceImpl();
    }

    @Test
    void checkBodyAsString(VertxTestContext context) {
        final var url = "https://www.samsung.com";
        openGraphService
                .fetchMetadata(url)
                .onComplete(context.succeeding(buffer -> {
                    context.verify(() -> {
                        System.out.println(buffer);
                        context.completeNow();
                    });
                }));
    }
}