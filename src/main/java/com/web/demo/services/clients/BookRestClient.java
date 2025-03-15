package com.web.demo.services.clients;

import com.web.demo.records.Book;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;

@HttpExchange("api/v1/Books")
public interface BookRestClient {
    @GetExchange
    Flux<Book> fetchBooks();
}
