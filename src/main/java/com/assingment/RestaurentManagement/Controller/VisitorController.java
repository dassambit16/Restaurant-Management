package com.assingment.RestaurentManagement.Controller;

import com.assingment.RestaurentManagement.Model.Food;
import com.assingment.RestaurentManagement.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {
    @Autowired
    FoodService foodService;

    @GetMapping("food/items")
    public List<Food> getAllFoodItems() {
        return foodService.getAllFood();
    }

}
