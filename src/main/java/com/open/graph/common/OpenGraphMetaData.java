package com.open.graph.common;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("ogImage")
    @JsonAlias("og:image")
    private String ogImage;

    @JsonProperty("ogTitle")
    @JsonAlias("og:title")
    private String ogTitle;

    @JsonProperty("ogDescription")
    @JsonAlias("og:description")
    private String ogDescription;

    @JsonProperty("ogType")
    @JsonAlias("og:type")
    private String ogType;

    @JsonProperty("ogUrl")
    @JsonAlias("og:url")
    private String ogUrl;

    @JsonProperty("ogLocale")
    @JsonAlias("og:loacale")
    private String ogLocale;

    @JsonProperty("ogSiteName")
    @JsonAlias("og:site_name")
    private String ogSiteName;

    @JsonProperty("ogAudio")
    @JsonAlias("og:audio")
    private String ogAudio;

    @JsonProperty("ogVideo")
    @JsonAlias("og:video")
    private String ogVideo;
}
