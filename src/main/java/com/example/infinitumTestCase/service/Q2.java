package com.example.infinitumTestCase.service;

import com.example.infinitumTestCase.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Q2 {

    public List<Post> mixByOwners(List<Post> posts) {
        Map<Integer, List<Post>> postsByOwner = new HashMap<>();

        for (Post post : posts) {
            postsByOwner
                    .computeIfAbsent(post.getUser().getId(), k -> new ArrayList<>())
                    .add(post);
        }

        List<Post> result = new ArrayList<>();
        boolean added = true;

        while (added) {
            added = false;
            for (Map.Entry<Integer, List<Post>> entry : postsByOwner.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    result.add(entry.getValue().remove(0));
                    added = true;
                }
            }
        }

        return result;
    }
}
