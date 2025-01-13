package com.saladbar.rinx.repository;

import com.saladbar.rinx.dto.LeagueView;
import com.saladbar.rinx.dto.TeamView;
import com.saladbar.rinx.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LeagueRepository  extends JpaRepository<League, Long> {
    Set<LeagueView> findAllBy();
    LeagueView findByLeagueId(long id);
}
