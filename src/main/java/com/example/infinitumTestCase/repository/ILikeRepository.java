package com.example.infinitumTestCase.repository;

import com.example.infinitumTestCase.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILikeRepository extends JpaRepository<Like, Integer> {
    List<Like> findByPostId(int postId);
    Optional<Like> findByPostIdAndUserId(int postId, int userId);
}
