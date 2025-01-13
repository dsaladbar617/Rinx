package com.saladbar.rinx.service;

import com.saladbar.rinx.entity.Goalie;

import java.util.List;

public interface GoalieService {
    List<Goalie> findAll();
    Goalie findById(long id);
    Goalie save(Goalie goalie);
    void delete(Goalie goalie);
    Goalie addGoalieToMember(long id);
}
