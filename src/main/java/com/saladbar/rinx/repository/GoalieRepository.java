package com.saladbar.rinx.repository;

import com.saladbar.rinx.entity.Goalie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalieRepository extends JpaRepository<Goalie, Integer> {
}
