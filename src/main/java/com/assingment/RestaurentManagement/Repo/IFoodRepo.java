package com.assingment.RestaurentManagement.Repo;

import com.assingment.RestaurentManagement.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food, Integer> {
}
