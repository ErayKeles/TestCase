package com.example.infinitumTestCase.service;

import com.example.infinitumTestCase.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Q3 {

    public List<Post> mergePosts(List<List<Post>> listOfPosts) {
        Map<Integer, Post> uniquePosts = new HashMap<>();

        for (List<Post> posts : listOfPosts) {
            for (Post post : posts) {
                uniquePosts.put(post.getId(), post);
            }
        }

        List<Post> allPosts = new ArrayList<>(uniquePosts.values());

        allPosts.sort((p1, p2) -> {
            if (p1.getCreatedAt() != p2.getCreatedAt()) {
                return Integer.compare(p2.getCreatedAt(), p1.getCreatedAt());
            }
            return Integer.compare(p2.getId(), p1.getId());
        });

        return allPosts;
    }
}
