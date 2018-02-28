package com.example.demo.Controllers;

import com.example.demo.Models.*;
import com.example.demo.Repositories.*;
import com.example.demo.Config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    // Autowired Repositories
    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    FoodItemsRepository foodItemsRepository;

    /////////////// METHODS //////////////////

    @RequestMapping("/")
    public String index(){
        return "homepage";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    // Security and User Methods

    @GetMapping("/register")
    public String registerUser(Model model)
    {
        model.addAttribute("newUser",new AppUser());
        return "registration";
    }

    @PostMapping("/register")
    public String addNewUser(@Valid @ModelAttribute("NewUser") AppUser newUser,  BindingResult result, Model model)
    {

        if(result.hasErrors())
        {
            System.out.println(result.toString());
            return "registration";
        }
        else{

            model.addAttribute(newUser.getAppUsername() + " created");
            appUserRepository.save(newUser);
            AppRole r = appRoleRepository.findAppRoleByRoleName("USER");
            newUser.addRole(r);
            appUserRepository.save(newUser);
            return "redirect:/login";
        }
    }

    @RequestMapping("/userdetail/{id}")
    public String showUserDetails(@PathVariable("id") long id, Model model){
        model.addAttribute("profile", appUserRepository.findOne(id));
        return "userprofile";
    }

    @PostMapping("/addadmin/{id}")
    public String changeToAdmin(@PathVariable("id") long id, Model model) {
        AppUser user = appUserRepository.findOne(id);
        AppRole role = appRoleRepository.findAppRoleByRoleName("ADMIN");
        user.addRole(role);
        appUserRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/change_RSVP_status/{id}")
    public String changeRSVPstatus(@PathVariable("id") long id, Model model){
        AppUser user = appUserRepository.findOne(id);
        user.setRsvpStatus(true);
        appUserRepository.save(user);
        return "redirect:/userdetail/{id}";
    }

    // Food Methods

    @RequestMapping("/foodlist")
    public String showFoodList(Model model){
        model.addAttribute("foodlist",foodItemsRepository.findAll());
        return "foodlistpage";
    }

    @GetMapping("/addfood")
    public String addFoodItem(Model model){
        model.addAttribute("addfood", new FoodItems());
        return "foodaddpage";
    }

    @PostMapping("/processfood")
    public String processFoodItem(@Valid @ModelAttribute("addfood") FoodItems foodItems, BindingResult result, Authentication authentication){
        if (result.hasErrors()){
            return "foodaddpage";
        }
        foodItemsRepository.save(foodItems);
        AppUser user = appUserRepository.findAppUserByAppUsername(authentication.getName());
        user.addFoodItems(foodItems);
        appUserRepository.save(user);
        return "redirect:/foodlist";
    }

    @GetMapping("/addedfood/{id}")
    public String foodAddedByAdmin(@PathVariable("id") long id, Model model){
        model.addAttribute("addfood",new FoodItems());
        model.addAttribute("user", appUserRepository.findOne(id));
        return "foodaddpage";
    }

    @PostMapping("/processaddedfood/{id}")
    public String processAddedFood(@Valid @ModelAttribute("addfood") @PathVariable("id") long id,
                                   FoodItems foodItems, BindingResult result){
        if (result.hasErrors()){
            return "foodaddpage";
        }
        foodItemsRepository.save(foodItems);
        AppUser user = appUserRepository.findOne(id);
        user.addFoodItems(foodItems);
        appUserRepository.save(user);
        return "";
    }

    @PostMapping("/searcfood")
    public String showSearchOrgResults(HttpServletRequest request, Model model)
    {
        //Get the search string from the result form
        String searchString = request.getParameter("search");
        model.addAttribute("search",searchString);
        model.addAttribute("foodlist",foodItemsRepository.findAllByItemNameContainingIgnoreCase(searchString));
        return "foodlistpage";
    }

}
