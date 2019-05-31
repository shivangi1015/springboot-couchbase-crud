package com.knoldus.blogs.handler;

import com.knoldus.blogs.models.Blogs;
import com.knoldus.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class BlogHandler {
    
    @Autowired
    private BlogRepository blogRepository;
    
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    public Mono<ServerResponse> addBlogPost(ServerRequest request) {
        Mono<Blogs> blogsMono = request.bodyToMono(Blogs.class);
        
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(blogsMono.flatMap(b -> blogRepository.save(b)), Blogs.class));
    }
    
    public Mono<ServerResponse> getBlog(ServerRequest request) {
        return blogRepository.existsById(String.valueOf(request.pathVariable("id")))
                .filter(booleanValue -> booleanValue.equals(true))
                .flatMap(boolValue -> ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(blogRepository
                                        .findById(String.valueOf(request.pathVariable("id"))),
                                Blogs.class));
    }
}
