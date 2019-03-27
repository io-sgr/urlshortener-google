# Google URL Shortener
[![Build Status](https://travis-ci.org/io-sgr/urlshortener-google.svg?branch=master)](https://travis-ci.org/io-sgr/urlshortener-google)[![codecov](https://codecov.io/gh/io-sgr/urlshortener-google/branch/master/graph/badge.svg)](https://codecov.io/gh/io-sgr/urlshortener-google)

A java library for Google URL Shortener

## How to use

```java
public class Example {
    
    public static void main(String... args) {
        GoogleURLShortener shortener = new GoogleURLShortener();
        String longUrl = "https://github.com/io-sgr/urlshortener-google";
        String shortUrl = shortener.shortenURL("<some_origin>", "<your_api_key>", longUrl);
        System.out.println(shortUrl);
    }
    
}
```
