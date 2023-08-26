package com.urlshortener.customurlshortener.exceptions;

import com.urlshortener.customurlshortener.model.CustomMessage;

public class UrlNotFoundException extends RuntimeException {
        public UrlNotFoundException(CustomMessage message) {
        super(String.valueOf(message));
    }
}
