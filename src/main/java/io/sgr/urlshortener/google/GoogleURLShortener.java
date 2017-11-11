/*
 * Copyright 2017 SgrAlpha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.sgr.urlshortener.google;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author SgrAlpha
 *
 */
public class GoogleURLShortener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger("google-url-shortener");
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper(new JsonFactory());
	private static final Converter.Factory DEFAULT_CONVERTER_FACTORY = JacksonConverterFactory.create(OBJECT_MAPPER);
	
	private final GoogleUrlShortenerApi api;
	
	public GoogleURLShortener() {
		OkHttpClient.Builder clientBuilder = new OkHttpClient().newBuilder()
				.retryOnConnectionFailure(true);
        this.api = new Retrofit.Builder()
        		.baseUrl("https://www.googleapis.com/")
        		.addConverterFactory(DEFAULT_CONVERTER_FACTORY)
        		.client(clientBuilder.build())
        		.build()
        		.create(GoogleUrlShortenerApi.class);
	}
	
	/**
	 * @param originHost
	 * 				Optional, unless your API is restricted, you can override hostname or IP here.
	 * @param apiKey
	 * 				The API key for Google URL Shortener API
	 * @param longURL
	 * 				The long URL which need to be shortened
	 * @return
	 * 				Shortened URL
	 */
	public String shortenURL(String originHost, String apiKey, String longURL) {
		if (originHost == null || apiKey == null || longURL == null) {
			return null;
		}
		ShortenUrlPayload payload = new ShortenUrlPayload(longURL);
		try {
			Response<URLShortenerResponse> resp = this.api.url(originHost, apiKey, payload).execute();
			if (resp == null) {
				return null;
			}
			if (resp.isSuccessful() && resp.body() != null) {
				return resp.body().getId();
			}
			if (resp.errorBody() != null) {
				LOGGER.error(resp.errorBody().string());
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
}
