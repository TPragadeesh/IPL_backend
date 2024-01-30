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
@Document(indexName = "player")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @Id
    @Field(type = FieldType.Text)
    private String playerName;

    @Field(type = FieldType.Text)
    private String category;

    @Field(type = FieldType.Text)
    private String auctionPrice;

    @Field(type = FieldType.Text)
    private String team;

    @Field(type = FieldType.Text)
    private String image;

    @Field(type = FieldType.Text)
    private String strength;

    @Field(type = FieldType.Text)
    private String weakness;

    @Field(type = FieldType.Text)
    private String status;


}
