package com.knoldus.blogs.controller;

import com.knoldus.blogs.models.Blog;
import com.knoldus.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    
    @Autowired
    BlogRepository blogRepository;
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    @PostMapping("/blog")
    public Blog addBlogPost(@RequestBody Blog newBlog) {
        return blogRepository.save(newBlog);
    }
    
    @GetMapping("/blog/get/{id}")
    public Optional<Blog> getBlog(@PathVariable String id) {
        System.out.println("\n\nhere......");
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/blog/count")
    public long countTotalBlogs() {
        return blogRepository.count();
    }
    
    @GetMapping("/blogs/author/{author}")
    public Blog getBlogByAuthorName(@PathVariable String author) {
        return blogRepository.findByAuthor(author);
    }
    
    @DeleteMapping("/blogs/topic/author/{topic}/{author}")
    public List<Blog> deleteByParams(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteBytopicAndAuthor(topic, author);
    }
    
    @DeleteMapping("/blogs/id/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }
}
