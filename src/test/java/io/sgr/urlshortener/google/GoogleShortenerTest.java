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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author SgrAlpha
 *
 */
public class GoogleShortenerTest {
	
	@Test
	public void test() {
		String apiKey = System.getenv("GOOGLE_API_KEY");
		if (apiKey == null) {
			return;
		}
		String origin = System.getenv("ORIGIN");
		if (origin == null) {
			return;
		}
		GoogleURLShortener shortener = new GoogleURLShortener();
		String longUrl = "https://github.com/sgr-io/urlshortener-google";
		try {
			String shortUrl = shortener.shortenURL(origin, apiKey, longUrl);
			Assert.assertEquals("https://goo.gl/Fv5gix", shortUrl);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
