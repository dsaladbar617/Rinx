package com.saladbar.rinx.repository;

import com.saladbar.rinx.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository  extends JpaRepository<League, Integer> {
}
