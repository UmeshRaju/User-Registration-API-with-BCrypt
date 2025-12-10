package com.springbootpractice.UserRegisteration.Repository;

import com.springbootpractice.UserRegisteration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
