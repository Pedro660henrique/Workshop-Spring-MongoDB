package com.demo.workshopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.workshopMongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
