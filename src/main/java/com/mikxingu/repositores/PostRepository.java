package com.mikxingu.repositores;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mikxingu.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}