package com.web.demo.services.clients;

import com.web.demo.records.Product;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;

@HttpExchange("/products")
public interface ProductRestClient {

    @GetExchange
    Flux<Product> fetchProducts();
}
