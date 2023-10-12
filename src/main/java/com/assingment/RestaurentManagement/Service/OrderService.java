package com.assingment.RestaurentManagement.Service;

import com.assingment.RestaurentManagement.Model.Food;
import com.assingment.RestaurentManagement.Model.Orders;
import com.assingment.RestaurentManagement.Model.User;
import com.assingment.RestaurentManagement.Repo.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iOrderRepo;
    @Autowired
    FoodService foodService;
    @Autowired
    UserService userService;

    public boolean addOrder(Orders orders, String email) {
        Food food = orders.getFood();

        boolean foodAvail = foodService.isFoodInMenu(food);
        User user = userService.iUserRepo.findFirstByUserEmail(email);

        if(foodAvail) {
            orders.setCustomer(user);
            iOrderRepo.save(orders);
            return true;
        }else {
            return false;
        }
    }
}
