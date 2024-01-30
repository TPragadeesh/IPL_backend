package com.example.cricket.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "manager")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Manager {

    @Id
    @Field(type = FieldType.Text)
    private String teamName;

    @Field(type = FieldType.Text)
    private String password;

    @Field(type = FieldType.Text)
    private String image;

    @Field(type = FieldType.Text)
    private String color;
}
