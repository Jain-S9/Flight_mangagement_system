package com.example.flightmanagementsystem.repositories;


import com.example.flightmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {

    User findByUserId(String userId);

}
