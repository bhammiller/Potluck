package com.example.demo.Config;

import com.example.demo.Models.AppRole;
import com.example.demo.Models.AppUser;
import com.example.demo.Models.FoodItems;
import com.example.demo.Repositories.AppRoleRepository;
import com.example.demo.Repositories.AppUserRepository;
import com.example.demo.Repositories.FoodItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    FoodItemsRepository foodItemsRepository;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data ...");
        AppRole role = new AppRole();
        role.setRoleName("USER");
        appRoleRepository.save(role);

        role = new AppRole();
        role.setRoleName("ADMIN");
        appRoleRepository.save(role);

        // Users
        // User 1
        AppUser appUser = new AppUser();
        appUser.setFirstName("John");
        appUser.setLastName("Doe");
        appUser.setUserEmail("g1@gmail.com");
        appUser.setUserImage("/img/faces/face-0.jpg");
        appUser.setAppUsername("john");
        appUser.setAppPassword("password1");
        appUserRepository.save(appUser);
        appUser.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(appUser);
        // User 2
        appUser = new AppUser();
        appUser.setFirstName("Jacob");
        appUser.setLastName("Smith");
        appUser.setUserEmail("g2@gmail.com");
        appUser.setUserImage("/img/faces/face-0.jpg");
        appUser.setAppUsername("jacob");
        appUser.setAppPassword("password2");
        appUserRepository.save(appUser);
        appUser.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(appUser);
        // User 3
        appUser = new AppUser();
        appUser.setFirstName("Joe");
        appUser.setLastName("blow");
        appUser.setUserEmail("g3@gmail.com");
        appUser.setUserImage("/img/faces/face-0.jpg");
        appUser.setAppUsername("joe");
        appUser.setAppPassword("password3");
        appUserRepository.save(appUser);
        appUser.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(appUser);

        // adding items

        FoodItems foodItems=new FoodItems();
        // Item 1
        foodItems.setItemName("Fried Chicken");
        foodItems.setServingSize(5);
        foodItems.setItemCategory("Food");
        appUser=appUserRepository.findById(new Long(1));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 2
        foodItems=new FoodItems();
        foodItems.setItemName("CocaCola");
        foodItems.setServingSize(3);
        foodItems.setItemCategory("Drink");
        appUser=appUserRepository.findById(new Long(1));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
//        appUser=appUserRepository.findById(new Long(1));
//        appUser.addFoodItems(foodItems);
//        appUserRepository.save(appUser);
        // Item 3
        foodItems=new FoodItems();
        foodItems.setItemName("Ice Cream");
        foodItems.setServingSize(4);
        foodItems.setItemCategory("Dessert");
        appUser=appUserRepository.findById(new Long(3));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 4
        foodItems=new FoodItems();
        foodItems.setItemName("Hot Dogs");
        foodItems.setServingSize(6);
        foodItems.setItemCategory("Food");
        appUser=appUserRepository.findById(new Long(2));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 5
        foodItems=new FoodItems();
        foodItems.setItemName("Pepsi");
        foodItems.setServingSize(1);
        foodItems.setItemCategory("Drink");
        appUser=appUserRepository.findById(new Long(2));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 6
        foodItems=new FoodItems();
        foodItems.setItemName("Cake");
        foodItems.setServingSize(8);
        foodItems.setItemCategory("Dessert");
        appUser=appUserRepository.findById(new Long(1));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 7
        foodItems=new FoodItems();
        foodItems.setItemName("Cassarole");
        foodItems.setServingSize(6);
        foodItems.setItemCategory("Food");
        appUser=appUserRepository.findById(new Long(3));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 8
        foodItems=new FoodItems();
        foodItems.setItemName("Water");
        foodItems.setServingSize(20);
        foodItems.setItemCategory("Drink");
        appUser=appUserRepository.findById(new Long(2));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 9
        foodItems=new FoodItems();
        foodItems.setItemName("Pie");
        foodItems.setServingSize(10);
        foodItems.setItemCategory("Dessert");
        appUser=appUserRepository.findById(new Long(3));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 10
        foodItems=new FoodItems();
        foodItems.setItemName("Pizza");
        foodItems.setServingSize(8);
        foodItems.setItemCategory("Food");
        appUser=appUserRepository.findById(new Long(1));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 11
        foodItems=new FoodItems();
        foodItems.setItemName("Iced Tea");
        foodItems.setServingSize(3);
        foodItems.setItemCategory("Drink");
        appUser=appUserRepository.findById(new Long(2));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 12
        foodItems=new FoodItems();
        foodItems.setItemName("Sorbet");
        foodItems.setServingSize(7);
        foodItems.setItemCategory("Dessert");
        appUser=appUserRepository.findById(new Long(2));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 13
        foodItems=new FoodItems();
        foodItems.setItemName("Lasagna");
        foodItems.setServingSize(11);
        foodItems.setItemCategory("Food");
        appUser=appUserRepository.findById(new Long(1));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 14
        foodItems=new FoodItems();
        foodItems.setItemName("Fanta");
        foodItems.setServingSize(100);
        foodItems.setItemCategory("Drink");
        appUser=appUserRepository.findById(new Long(3));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);
        // Item 15
        foodItems=new FoodItems();
        foodItems.setItemName("Fudge");
        foodItems.setServingSize(15);
        foodItems.setItemCategory("Dessert");
        appUser=appUserRepository.findById(new Long(1));
        foodItems.setAppUser(appUser);
        foodItemsRepository.save(foodItems);
        appUser.addFoodItems(foodItems);
        appUserRepository.save(appUser);

        appUser=appUserRepository.findById(new Long(2));

        System.out.println(appUser.getFoodItemsList());
        /*List<FoodItems> list = appUser.getFoodItemsList();
        for (foodItems : list) {

        }
*/
    }
}