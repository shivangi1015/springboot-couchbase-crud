package com.knoldus.blogs.repository;

import com.knoldus.blogs.models.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog, String> {


}