package com.web.demo.services;

import com.web.demo.records.Posts;
import com.web.demo.records.Product;
import reactor.core.publisher.Flux;

public interface FakeWebClientService {
    Flux<Posts> fetchPosts();
    Flux<Product> fetchProducts();
}
