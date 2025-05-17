package com.saladbar.rinx.goalie.repository;

import com.saladbar.rinx.model.entity.Goalie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalieRepository extends JpaRepository<Goalie, Long> {
}
