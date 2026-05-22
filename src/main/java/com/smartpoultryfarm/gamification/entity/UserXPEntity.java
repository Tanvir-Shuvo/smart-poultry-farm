package com.smartpoultryfarm.gamification.entity;

import com.smartpoultryfarm.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "user_xp")
public class UserXPEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer xp = 0;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}