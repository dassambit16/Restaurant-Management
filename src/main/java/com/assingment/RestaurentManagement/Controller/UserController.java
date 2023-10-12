package com.assingment.RestaurentManagement.Controller;

import com.assingment.RestaurentManagement.Model.Food;
import com.assingment.RestaurentManagement.Model.Orders;
import com.assingment.RestaurentManagement.Model.User;
import com.assingment.RestaurentManagement.Model.dto.SignInInput;
import com.assingment.RestaurentManagement.Model.dto.SignUpOutput;
import com.assingment.RestaurentManagement.Service.AuthTokenService;
import com.assingment.RestaurentManagement.Service.FoodService;
import com.assingment.RestaurentManagement.Service.OrderService;
import com.assingment.RestaurentManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FoodService foodService;
    @Autowired
    AuthTokenService authTokenService;

    @Autowired
    OrderService orderService;

    @PostMapping("user/singUp")
    public SignUpOutput signUpUser(@RequestBody User user) {
        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String signInUser(@RequestBody SignInInput signInInput) {
        return userService.signInUser(signInInput);
    }

    @GetMapping("food")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @PostMapping("order")
    public String addOrder(@RequestBody Orders orders, @RequestParam String email, @RequestParam String token) {
        if(authTokenService.authenticate(email,token)) {
            boolean foodOrdered = orderService.addOrder(orders,email);

            return  foodOrdered?"Food ordered":"The food you are trying to order is Not available in the menu";
        }else {
            return "Sign in to order Food";
        }
    }
}
