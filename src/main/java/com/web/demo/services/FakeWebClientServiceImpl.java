package com.web.demo.services;

import com.web.demo.records.Book;
import com.web.demo.records.Posts;
import com.web.demo.records.Product;
import com.web.demo.services.clients.BookRestClient;
import com.web.demo.services.clients.JsonPlaceHolderClient;
import com.web.demo.services.clients.ProductRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FakeWebClientServiceImpl implements FakeWebClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeWebClientServiceImpl.class);

    private final JsonPlaceHolderClient jsonPlaceHolderClient;
    private final ProductRestClient productsRestClient;
    private final BookRestClient bookRestController;

    public FakeWebClientServiceImpl(JsonPlaceHolderClient jsonPlaceHolderClient,
                                    ProductRestClient productsRestClient,
                                    BookRestClient bookRestController
    ) {
        this.jsonPlaceHolderClient = jsonPlaceHolderClient;
        this.productsRestClient = productsRestClient;
        this.bookRestController = bookRestController;
    }

    @Override
    public Flux<Posts> fetchPosts() {
        LOGGER.info("getAllPosts URL::");
        return jsonPlaceHolderClient.getAllPosts();
    }

    @Override
    public Flux<Product> fetchProducts() {
        LOGGER.info("fetchProducts URL::");
        return productsRestClient.fetchProducts();
    }

    @Override
    public Flux<Book> fetchBooks() {
        LOGGER.info("fetchBooks URL::");
        return bookRestController.fetchBooks();
    }


}
