package com.example.demo.Repositories;

import com.example.demo.Models.AppUser;
import com.example.demo.Models.FoodItems;
import org.springframework.data.repository.CrudRepository;

public interface FoodItemsRepository extends CrudRepository<FoodItems, Long> {
    Iterable<FoodItems> findAllByItemNameContainingIgnoreCase(String search);
    Iterable<FoodItems> findAllByAppUserIs(AppUser appUser);
}
