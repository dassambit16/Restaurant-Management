package com.assingment.RestaurentManagement.Repo;

import com.assingment.RestaurentManagement.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {
    Admin findFirstByAdminEmail(String email);
}
