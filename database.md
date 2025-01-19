CREATE DATABASE test_case;
USE test_case;

-- user tablosu
CREATE TABLE user (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL,
full_name VARCHAR(255),
profile_picture VARCHAR(255),
bio VARCHAR(3000),
created_at INT
);

-- post tablosu
CREATE TABLE post (
id INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR(1000),
user_id INT,
image VARCHAR(255),
created_at INT,
FOREIGN KEY (user_id) REFERENCES user(id)
);

-- follow tablosu
CREATE TABLE follow (
follower_id INT,
following_id INT,
created_at INT,
PRIMARY KEY (follower_id, following_id),
FOREIGN KEY (follower_id) REFERENCES user(id),
FOREIGN KEY (following_id) REFERENCES user(id)
);

-- like tablosu
CREATE TABLE `like` (
id INT AUTO_INCREMENT PRIMARY KEY,
post_id INT,
user_id INT,
created_at INT,
FOREIGN KEY (post_id) REFERENCES post(id),
FOREIGN KEY (user_id) REFERENCES user(id)
);
