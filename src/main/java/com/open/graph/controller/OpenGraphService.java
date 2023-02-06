package com.open.graph.controller;

import com.open.graph.common.OpenGraphMetaData;
import io.vertx.core.Future;

/**
 * @author Pratyay Ganguli
 */

public interface OpenGraphService {
    public Future<OpenGraphMetaData> fetchMetadata(String url);
}
