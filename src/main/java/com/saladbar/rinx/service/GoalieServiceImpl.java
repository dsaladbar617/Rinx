package com.saladbar.rinx.service;

import com.saladbar.rinx.dao.GoalieRepository;
import com.saladbar.rinx.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Goalie")
public class GoalieServiceImpl implements PlayerService{

    private final GoalieRepository goalieRepository;

    @Autowired
    public GoalieServiceImpl(GoalieRepository goalieRepository) {
        this.goalieRepository = goalieRepository;
    }

    @Override
    public List<Player> findAll() {
        return goalieRepository.findAll();
    }

    @Override
    public Player findById(int id) {
        return goalieRepository.findById(id).orElse(null);
    }

    @Override
    public Player save(Player player) {
        return goalieRepository.save(player);
    }

    @Override
    public void delete(Player player) {
        goalieRepository.delete(player);
    }
}
