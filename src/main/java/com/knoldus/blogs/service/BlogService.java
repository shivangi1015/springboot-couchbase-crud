package com.knoldus.blogs.service;

import com.knoldus.blogs.handler.BlogHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class BlogService {
    
    @Bean
    public RouterFunction<ServerResponse> route(BlogHandler handler) {
        return RouterFunctions.route()
                .path("/blogs", builder -> builder
                        .GET("/{id}", accept(APPLICATION_JSON), handler::getBlog)
                        .POST("/add", accept(APPLICATION_JSON), handler::addBlogPost)
                ).build();
    }
}
