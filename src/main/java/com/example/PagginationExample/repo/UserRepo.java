package com.example.PagginationExample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.PagginationExample.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
