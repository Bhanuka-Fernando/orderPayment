package com.fooddelivery.orderpayment.repository;

import com.fooddelivery.orderpayment.model.Restaurants;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurants,String> {
    List<Restaurants> findByRestaurantId(String restaurantId);
}
