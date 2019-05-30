package com.knoldus.blogs.repository;

import com.knoldus.blogs.models.Blogs;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface BlogRepository extends ReactiveCouchbaseRepository<Blogs, String> {
    
    Flux<Blogs> findByAuthor(String author);
    
    Mono<Blogs> deleteBytopicAndAuthor(String title, String author);
}