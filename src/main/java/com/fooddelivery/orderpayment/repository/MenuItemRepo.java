package com.fooddelivery.orderpayment.repository;

import com.fooddelivery.orderpayment.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MenuItemRepo extends MongoRepository<MenuItem, String> {
    List<MenuItem> findByRestaurantId(String restaurantId);
}

