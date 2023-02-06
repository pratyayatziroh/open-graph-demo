package com.open.graph.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pratyay Ganguli
 */

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OpenGraphMetaData {
    private String ogImage;
    private String ogTitle;
    private String ogDescription;
    private String ogType;
    private String ogUrl;
    private String ogLocale;
    private String ogSiteName;
    private String ogAudio;
    private String ogVideo;
}
