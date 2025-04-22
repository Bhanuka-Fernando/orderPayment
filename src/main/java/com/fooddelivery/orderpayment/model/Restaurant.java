package com.fooddelivery.orderpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "rest")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String ownerName;
    private String openingTime;
    private String closingTime;

    // Constructors, Getters & Setters
}