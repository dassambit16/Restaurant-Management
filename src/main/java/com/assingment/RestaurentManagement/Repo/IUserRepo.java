package com.assingment.RestaurentManagement.Repo;

import com.assingment.RestaurentManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByUserEmail(String newEmail);
}
