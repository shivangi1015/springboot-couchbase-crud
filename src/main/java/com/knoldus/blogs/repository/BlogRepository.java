package com.knoldus.blogs.repository;

import com.knoldus.blogs.models.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, String> {


}