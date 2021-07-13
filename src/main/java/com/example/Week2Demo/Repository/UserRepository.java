package com.example.Week2Demo.Repository;

import com.example.Week2Demo.model.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
