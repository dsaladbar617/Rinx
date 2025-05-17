package com.saladbar.rinx.league.repository;

import com.saladbar.rinx.model.dto.LeagueView;
import com.saladbar.rinx.model.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface LeagueRepository  extends JpaRepository<League, Long> {
    Set<LeagueView> findAllBy();
    Optional<LeagueView> findByLeagueId(long id);
    Optional<League> findByLeagueName(String name);
}
