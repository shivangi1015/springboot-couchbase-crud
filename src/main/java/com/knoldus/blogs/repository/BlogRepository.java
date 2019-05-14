package com.knoldus.blogs.repository;

import com.knoldus.blogs.models.Blog;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BlogRepository extends CrudRepository<Blog, String> {
    
    Blog findByAuthor(String author);
    
    List<Blog> deleteBytopicAndAuthor(String title, String author);
    
}