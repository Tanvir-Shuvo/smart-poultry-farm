package com.smartpoultryfarm.gamification.service;

import com.smartpoultryfarm.entity.User;
import com.smartpoultryfarm.gamification.entity.UserXPEntity;
import com.smartpoultryfarm.gamification.repository.UserXPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamificationService {

    @Autowired
    private UserXPRepository userXPRepository;

    // EXPENSE XP
    public void addXP(User user){

        UserXPEntity userXP =
                userXPRepository.findByUser(user);

        if(userXP == null){
            userXP = new UserXPEntity();
            userXP.setUser(user);
            userXP.setXp(10);
        }else{
            userXP.setXp(userXP.getXp() + 10);
        }

        userXPRepository.save(userXP);
    }

    // LOGIN XP (OPTIONAL)
    public void addLoginXP(User user){

        UserXPEntity userXP =
                userXPRepository.findByUser(user);

        if(userXP == null){
            userXP = new UserXPEntity();
            userXP.setUser(user);
            userXP.setXp(5);
        }else{
            userXP.setXp(userXP.getXp() + 5);
        }

        userXPRepository.save(userXP);
    }

    // GET XP
    public Integer getXP(User user){

        UserXPEntity userXP =
                userXPRepository.findByUser(user);

        if(userXP == null){
            return 0;
        }

        return userXP.getXp();
    }
}