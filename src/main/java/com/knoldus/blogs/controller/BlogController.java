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
    
    @PostMapping("/blog/add")
    public Blog addBlogPost(@RequestBody Blog newBlog) {
        return blogRepository.save(newBlog);
    }
    
    @GetMapping("/blog/get/{id}")
    public Optional<Blog> getBlog(@PathVariable String id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/blog/count")
    public long countTotalBlogs() {
        System.out.println("==here... ");
        return blogRepository.count();
    }
    
    @GetMapping("/blogs/count/author/{author}")
    public long countBlogsPerAuthor(@PathVariable String author) {
        return blogRepository.countByAuthor(author);
    }
    
    @DeleteMapping("/blogs/delete/{title}/{author}")
    public long deleteByParams(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteBytopicAndAuthor(topic, author);
    }
    
    @GetMapping("/blogs/get/tag/{tag}")
    public List<Blog> getBlogs(@PathVariable String tag) {
        return blogRepository.findByTags(tag);
    }
}
