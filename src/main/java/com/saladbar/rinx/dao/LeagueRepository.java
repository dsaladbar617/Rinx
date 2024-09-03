package com.saladbar.rinx.dao;

import com.saladbar.rinx.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository  extends JpaRepository<League, Integer> {
}
