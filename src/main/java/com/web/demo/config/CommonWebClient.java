package com.web.demo.config;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Map;

public class CommonWebClient {

    public <S> S createClient(Class<S> serviceType, String url, Map<String, String> headersMap) {
        return HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(createWebClient(url, headersMap)))
                .build()
                .createClient(serviceType);
    }

    private WebClient createWebClient(String url, Map<String,String> headers){
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeaders(header -> headers.forEach(header::add))
                .build();
    }

    /*
     private WebClient createWebClientWithFilter(String url, Map<String,String> headers){
        return WebClient.builder()
                .baseUrl(url)
                .filters(exchangeFilterFunctions -> {
                    exchangeFilterFunctions.add(new AuditClientFilter());
                })
                .defaultHeaders(header -> headers.forEach(header::add))
                .build();
    }

    private WebClient createAuditWebClient(String url, Map<String, String> headers) {
        return WebClient.builder()
                .baseUrl(url)
                .defaultHeaders(header -> headers.forEach(header::add))
                .build();
    }

    public <S> S createAuditClient(Class<S> serviceType, String url, Map<String, String> headersMap) {
        return HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(createAuditWebClient(url, headersMap)))
                .build()
                .createClient(serviceType);
    }*/
}
