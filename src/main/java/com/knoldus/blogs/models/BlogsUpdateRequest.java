package com.knoldus.blogs.models;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class BlogsUpdateRequest {
    
    @Size(min = 10)
    @Field
    String topic;
    
    @Field
    List<String> tags;
}
