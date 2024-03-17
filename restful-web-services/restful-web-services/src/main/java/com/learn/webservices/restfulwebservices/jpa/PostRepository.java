package com.learn.webservices.restfulwebservices.jpa;

import com.learn.webservices.restfulwebservices.user.Post;
import com.learn.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
