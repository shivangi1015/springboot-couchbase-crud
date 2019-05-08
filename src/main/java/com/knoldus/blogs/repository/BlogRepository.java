package com.knoldus.blogs.repository;

import com.knoldus.blogs.models.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, String> {
    
    long countByAuthor(String author);
    
    long deleteBytopicAndAuthor(String title, String author);
    
    List<Blog> findByTags(String tag);
}