package com.saladbar.rinx.league.repository;

import com.saladbar.rinx.models.dto.LeagueView;
import com.saladbar.rinx.models.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface LeagueRepository  extends JpaRepository<League, Long> {
    Set<LeagueView> findAllBy();
    LeagueView findByLeagueId(long id);
}
