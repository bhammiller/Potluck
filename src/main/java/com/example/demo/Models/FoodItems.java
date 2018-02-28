package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String itemName;

    private Integer servingSize;

    private String itemCategory;

    // Constructors


    public FoodItems(String itemName, Integer servingSize, String itemCategory, String appUser) {
        this.itemName = itemName;
        this.servingSize = servingSize;
        this.itemCategory = itemCategory;
        this.appUser = appUser;
    }

    public FoodItems() {
    }

    // Variable Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getServingSize() {
        return servingSize;
    }

    public void setServingSize(Integer servingSize) {
        this.servingSize = servingSize;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    // Connection to AppUser
    @ManyToOne()
    private String appUser;

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }
}
