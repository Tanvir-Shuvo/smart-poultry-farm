package com.smartpoultryfarm.gamification.repository;

import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.gamification.entity.UserXPEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserXPRepository
        extends JpaRepository<UserXPEntity, Long> {

    UserXPEntity findByUser(User user);
}