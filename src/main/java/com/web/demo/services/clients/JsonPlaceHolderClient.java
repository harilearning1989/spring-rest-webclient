package com.web.demo.services.clients;

import com.web.demo.records.Posts;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Flux;

@HttpExchange("/posts")
public interface JsonPlaceHolderClient {

    @GetExchange
    Flux<Posts> getAllPosts();

    @GetExchange("/{id}")
    Posts getPostById(@PathVariable("id") Long id);

    @PostExchange
    Posts createPost(@RequestBody Posts employeeDTO);

    @PutExchange("/{id}")
    Posts updatePost(@PathVariable("id") Long id, @RequestBody Posts employeeDTO);

    @DeleteExchange("/{id}")
    void deletePost(@PathVariable("id") Long id);
}
