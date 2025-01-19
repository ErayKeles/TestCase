package com.example.infinitumTestCase;

import com.example.infinitumTestCase.model.Post;
import com.example.infinitumTestCase.model.User;
import com.example.infinitumTestCase.service.Q2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Q2Test {

    @Autowired
    private Q2 q2;

    private List<Post> posts;

    @BeforeEach
    public void setUp() {
        // Test için bazı kullanıcılar ve gönderiler ekleyelim
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user1");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");

        Post post1 = new Post();
        post1.setId(1);
        post1.setUser(user1);
        post1.setDescription("User1 post");

        Post post2 = new Post();
        post2.setId(2);
        post2.setUser(user2);
        post2.setDescription("User2 post");

        posts = List.of(post1, post2);
    }

    @Test
    public void testMixByOwners() {
        List<Post> mixedPosts = q2.mixByOwners(posts);
        assertEquals(2, mixedPosts.size());
        assertEquals("User1 post", mixedPosts.get(0).getDescription());
    }
}
