package com.knoldus.blogs.models;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

@Builder
@Data
@AllArgsConstructor
@Document
public class Blog {
    
    @Id @GeneratedValue(strategy = UNIQUE)
    final String id;
    
    @Size(min=10)
    @NotNull
    @Field
    String topic;
    
    @NotNull
    @Field
    String author;
    
    @Field
    List<String> tags;
   /*
    @Field
    Date date;*/
    
}
