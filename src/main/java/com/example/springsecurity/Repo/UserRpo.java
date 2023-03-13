package com.example.springsecurity.Repo;

import com.example.springsecurity.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRpo extends MongoRepository<User,Integer> {
    Optional<User> findByName(String name);
//    List<User> findByUserName(String name);
}
