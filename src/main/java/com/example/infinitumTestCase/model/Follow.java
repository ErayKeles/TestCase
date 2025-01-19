package com.example.infinitumTestCase.model;
import jakarta.persistence.*;

@Entity
@Table(name = "follow")
public class Follow {

    @ManyToOne
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_id", nullable = false)
    private User following;

    @Column(name = "created_at")
    private int createdAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // JPA için birincil anahtar gerekli olduğundan bir ekleme yapıldı

    // Getters Setters
    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }
}
