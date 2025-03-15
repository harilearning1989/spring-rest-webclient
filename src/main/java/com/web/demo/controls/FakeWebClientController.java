package com.web.demo.controls;

import com.web.demo.records.Posts;
import com.web.demo.records.Product;
import com.web.demo.services.FakeWebClientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/stream")
public class FakeWebClientController {

    private final FakeWebClientService fakeApiService;

    public FakeWebClientController(FakeWebClientService fakeApiService) {
        this.fakeApiService = fakeApiService;
    }

    @GetMapping(value = "/posts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Posts> streamAllPosts() {
        return fakeApiService.fetchPosts();
    }

    @GetMapping(value = "/products", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getProducts() {
        return fakeApiService.fetchProducts();
    }

}

