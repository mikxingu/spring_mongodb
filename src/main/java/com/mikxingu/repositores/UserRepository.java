package com.mikxingu.repositores;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mikxingu.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}