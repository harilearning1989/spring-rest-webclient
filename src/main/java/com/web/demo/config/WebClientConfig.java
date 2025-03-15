package com.web.demo.config;

import com.web.demo.services.clients.BookRestClient;
import com.web.demo.services.clients.JsonPlaceHolderClient;
import com.web.demo.services.clients.ProductRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebClientConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientConfig.class);

    @Value("${json.placeholder}")
    private String jsonPlaceHolder;
    @Value("${json.products}")
    private String jsonProducts;
    @Value("${json.fakeRestApi}")
    private String fakeRestApi;

    @Value("${header.key}")
    private String headerKey;
    @Value("${header.value}")
    private String headerValue;

    @Bean
    public JsonPlaceHolderClient jsonPlaceHolderClient() {
        LOGGER.info("WebClientConfig  jsonPlaceHolder::{}", jsonPlaceHolder);
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(headerKey, headerValue);
        return new CommonWebClient()
                .createClient(JsonPlaceHolderClient.class, jsonPlaceHolder, headersMap);
    }

    @Bean
    public ProductRestClient jsonProductsClient() {
        LOGGER.info("WebClientConfig  jsonProducts::{}", jsonProducts);
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(headerKey, headerValue);
        return new CommonWebClient()
                .createClient(ProductRestClient.class, jsonProducts, headersMap);
    }

    @Bean
    public BookRestClient bookRestClient() {
        LOGGER.info("WebClientConfig  fakeRestApi::{}", fakeRestApi);
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(headerKey, headerValue);
        return new CommonWebClient()
                .createClient(BookRestClient.class, fakeRestApi, headersMap);
    }

}
