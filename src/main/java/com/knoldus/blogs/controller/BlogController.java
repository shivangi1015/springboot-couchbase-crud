package com.knoldus.blogs.controller;

import com.knoldus.blogs.models.Blog;
import com.knoldus.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    
    @Autowired
    BlogRepository blogRepository;
    
    @RequestMapping("/")
    public String index() {
        return "Welcome to the CRUD application!!";
    }
    
    @PostMapping("/blog/add")
    public Blog addBlogPost(@RequestBody Blog newBlog) {
        return blogRepository.save(newBlog);
    }
    
    @GetMapping("/blog/get/{id}")
    public boolean getBlog(@PathVariable String id) {
        return blogRepository.existsById(id);
    }
}
