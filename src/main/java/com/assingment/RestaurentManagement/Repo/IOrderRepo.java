package com.assingment.RestaurentManagement.Repo;

import com.assingment.RestaurentManagement.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Orders, Integer> {
}
