package com.demo.workshopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.workshopMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
