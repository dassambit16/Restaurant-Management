package com.assingment.RestaurentManagement.Service;

import com.assingment.RestaurentManagement.Model.Food;
import com.assingment.RestaurentManagement.Repo.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    IFoodRepo iFoodRepo;

    public List<Food> getAllFood() {
        return iFoodRepo.findAll();
    }

    public void addFoodItems(Food food) {
        iFoodRepo.save(food);
    }

    public boolean isFoodInMenu(Food food) {
        Integer id = food.getFoodId();
        return iFoodRepo.existsById(id);
    }
}
