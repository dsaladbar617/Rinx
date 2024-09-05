package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Goalie;
import com.saladbar.rinx.repository.GoalieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("Goalie")
public class GoalieServiceImpl implements GoalieService{

    private final GoalieRepository goalieRepository;

    @Autowired
    public GoalieServiceImpl(GoalieRepository goalieRepository) {
        this.goalieRepository = goalieRepository;
    }

    @Override
    public List<Goalie> findAll() {
        return goalieRepository.findAll();
    }

    @Override
    public Goalie findById(int id) {
        return goalieRepository.findById(id).orElse(null);
    }

    @Override
    public Goalie save(Goalie goalie) {
        return goalieRepository.save(goalie);
    }

    @Override
    public void delete(Goalie goalie) {
        goalieRepository.delete(goalie);
    }
}
