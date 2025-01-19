package com.example.infinitumTestCase.repository;

import com.example.infinitumTestCase.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFollowRepository extends JpaRepository<Follow, Integer> {
    Optional<Follow> findByFollowerIdAndFollowingId(int followerId, int followingId);
    List<Follow> findByFollowerId(int followerId);
    List<Follow> findByFollowingId(int followingId);
}
