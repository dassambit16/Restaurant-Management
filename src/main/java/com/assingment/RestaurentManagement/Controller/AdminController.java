package com.assingment.RestaurentManagement.Controller;

import com.assingment.RestaurentManagement.Model.Admin;
import com.assingment.RestaurentManagement.Model.Food;
import com.assingment.RestaurentManagement.Model.dto.SignInInput;
import com.assingment.RestaurentManagement.Service.AdminService;
import com.assingment.RestaurentManagement.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FoodService foodService;

    @PostMapping("admin/singUp")
    public String adminSingUp(@RequestBody Admin admin) {
        return adminService.adminSingUp(admin);
    }

    @PostMapping("admin/food")
    public String addFoodItems(@RequestBody Food food, @RequestParam String adminEmail) {
        boolean adminExist = adminService.ifAdminExistOrNot(adminEmail);

        if(adminExist) {
            foodService.addFoodItems(food);
            return "Food added";
        }
        else return "UnAuthorized access";
    }
}
