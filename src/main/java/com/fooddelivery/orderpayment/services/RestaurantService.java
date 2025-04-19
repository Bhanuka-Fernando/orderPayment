package com.fooddelivery.orderpayment.services;


import com.fooddelivery.orderpayment.model.Restaurants;
import com.fooddelivery.orderpayment.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    // create restaurant
    public Restaurants createRestaurant(Restaurants restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // delete Restaurant
    public void deleteRestaurant(String restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    // Get all restaurants
    public List<Restaurants> getAllRestaurants(){
        return restaurantRepository.findAll();
    }

}

