package com.example.infinitumTestCase.service;

import com.example.infinitumTestCase.model.Post;
import com.example.infinitumTestCase.model.User;
import com.example.infinitumTestCase.repository.IFollowRepository;
import com.example.infinitumTestCase.repository.ILikeRepository;
import com.example.infinitumTestCase.repository.IPostRepository;
import com.example.infinitumTestCase.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Q1 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Post> getPosts(int userId, List<Integer> postIds) {
        List<Post> result = new ArrayList<>();

        for (int postId : postIds) {
            //Gönderi
            String postQuery = "SELECT * FROM post WHERE id = ?";
            List<Post> dbPosts = jdbcTemplate.query(postQuery, new Object[]{postId}, (rs, rowNum) -> {
                Post post = new Post();
                post.setId(rs.getInt("id"));
                post.setDescription(rs.getString("description"));
                post.setImage(rs.getString("image"));
                post.setCreatedAt(rs.getInt("created_at"));
                return post;
            });

            if (!dbPosts.isEmpty()) {
                Post post = dbPosts.get(0);

                //Gönderi Sahibi
                String userQuery = "SELECT * FROM user WHERE id = ?";
                List<User> dbUsers = jdbcTemplate.query(userQuery, new Object[]{post.getUser().getId()}, (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setFullName(rs.getString("full_name"));
                    user.setProfilePicture(rs.getString("profile_picture"));
                    return user;
                });

                if (!dbUsers.isEmpty()) {
                    User owner = dbUsers.get(0);

                    //Beğeni
                    String likeQuery = "SELECT * FROM `like` WHERE post_id = ? AND user_id = ?";
                    boolean isLiked = !jdbcTemplate.query(likeQuery, new Object[]{postId, userId}, (rs, rowNum) -> rs).isEmpty();

                    //Takip
                    String followQuery = "SELECT * FROM follow WHERE follower_id = ? AND following_id = ?";
                    boolean isFollowed = !jdbcTemplate.query(followQuery, new Object[]{userId, owner.getId()}, (rs, rowNum) -> rs).isEmpty();

                    result.add(post);
                }
            } else {
                result.add(null);
            }
        }
        return result;
    }
}
