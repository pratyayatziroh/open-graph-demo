package com.open.graph.controller;

import org.junit.jupiter.api.Test;

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
