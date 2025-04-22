package com.fooddelivery.orderpayment.repository;

import com.fooddelivery.orderpayment.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepo extends MongoRepository<Restaurant,String> {
    List<Restaurant> findByOwnerName(String ownerName);



}