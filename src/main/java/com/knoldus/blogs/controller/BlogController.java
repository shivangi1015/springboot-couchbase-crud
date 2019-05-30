package com.knoldus.blogs.controller;

import com.knoldus.blogs.models.Blogs;
import com.knoldus.blogs.models.BlogsUpdateRequest;
import com.knoldus.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BlogController {
    
    @Autowired
    private BlogRepository blogRepository;
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    @PostMapping("/blogs/add")
    public Mono<Blogs> addBlogPost(@RequestBody Blogs newBlog) {
        return blogRepository.save(newBlog);
    }
    
    @GetMapping("blogs/{id}")
    public Mono<Blogs> getBlog(@PathVariable String id) {
        return blogRepository.existsById(id)
                .filter(booleanValue -> booleanValue.equals(true))
                .flatMap(boolValue -> blogRepository.findById(id));
    }
    
  /*  @GetMapping("/count")
    public Mono<Long> countTotalBlogs() {
        return blogRepository.count();
    }*/
    
    @GetMapping("/blogs/author/{author}")
    public ResponseEntity<Flux<Blogs>> getBlogByAuthorName(@PathVariable String author) {
        Flux<Blogs> byAuthor = blogRepository.findByAuthor(author);
        return ResponseEntity.ok().body(byAuthor);
    }
  /*
    @DeleteMapping("/blogs/topic/{topic}/author/{author}")
    public Mono<Blogs> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteBytopicAndAuthor(topic, author);
    }
    
    @DeleteMapping("/blogs/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return blogRepository.deleteById(id);
    }*/
    
    @PutMapping("/blogs/{idToBeUpdated}")
    public Mono<String> updateBlog(@PathVariable String idToBeUpdated,
                                   @RequestBody BlogsUpdateRequest blogsUpdateRequest) {
        
        return blogRepository.findById(idToBeUpdated)
                .flatMap(blog -> blogRepository
                        .save(Blogs
                                .builder()
                                .id(idToBeUpdated)
                                .topic(blogsUpdateRequest.getTopic())
                                .tags(blogsUpdateRequest.getTags())
                                .author(blog.getAuthor())
                                .date(blog.getDate())
                                .build())
                )
                .switchIfEmpty(Mono.just(Blogs.builder().build()))
                .flatMap(blog -> {
                    if (blog.getId() != null) {
                        return Mono.just("Blog Updated");
                    } else {
                        return Mono.just("Blog does not exist");
                    }
                });
        
    }
}
