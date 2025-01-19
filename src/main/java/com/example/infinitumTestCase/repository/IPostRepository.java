package com.example.infinitumTestCase.repository;

import com.example.infinitumTestCase.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int userId);
    List<Post> findByDescriptionContaining(String description);
}
