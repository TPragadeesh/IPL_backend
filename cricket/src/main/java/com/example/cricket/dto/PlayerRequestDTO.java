package com.example.cricket.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
public class PlayerRequestDTO {

    String playerName;
    String category;
    String auctionPrice;
    String team;
    String image;
    String strength;
    String weakness;
    String status;

}
