package com.knoldus.blogs.models;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@Document
public class Blog {
    
    @Id
    String id;
    
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
