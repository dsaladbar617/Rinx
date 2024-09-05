package com.saladbar.rinx.repository;

import com.saladbar.rinx.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
