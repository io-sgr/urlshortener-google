# Google URL Shortener
[![Build Status](https://travis-ci.org/sgr-io/urlshortener-google.svg?branch=master)](https://travis-ci.org/sgr-io/urlshortener-google)[![codecov](https://codecov.io/gh/sgr-io/urlshortener-google/branch/master/graph/badge.svg)](https://codecov.io/gh/sgr-io/urlshortener-google)

A java library for Google URL Shortener

## How to use

```java
public class Example {
    
    public static void main(String... args) {
        GoogleURLShortener shortener = new GoogleURLShortener();
        String longUrl = "https://github.com/sgr-io/urlshortener-google";
        String shortUrl = shortener.shortenURL("<some_origin>", "<your_api_key>", longUrl);
        System.out.println(shortUrl);
    }
    
}
```
