/*
 * Copyright 2017-2019 SgrAlpha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.sgr.urlshortener.google;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SgrAlpha
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class URLShortenerResponse {

    private final String kind;
    private final String id;
    private final String longUrl;

    /**
     * @param kind
     *         The type of response
     * @param id
     *         The short URL
     * @param longUrl
     *         The original long URL
     */
    @JsonCreator
    public URLShortenerResponse(
            @JsonProperty("kind") String kind,
            @JsonProperty("id") String id,
            @JsonProperty("longUrl") String longUrl) {
        this.kind = kind;
        this.id = id;
        this.longUrl = longUrl;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return the longUrl
     */
    public String getLongUrl() {
        return this.longUrl;
    }

}
