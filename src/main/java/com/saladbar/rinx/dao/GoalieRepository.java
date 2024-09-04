package com.saladbar.rinx.dao;

import com.saladbar.rinx.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalieRepository extends JpaRepository<Player, Integer> {
}
