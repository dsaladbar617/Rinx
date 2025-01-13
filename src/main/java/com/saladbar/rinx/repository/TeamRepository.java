package com.saladbar.rinx.repository;

import com.saladbar.rinx.dto.TeamView;
import com.saladbar.rinx.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Long> {
    TeamView findTeamViewByTeamId(long id);
    Set<TeamView> findAllBy();
}
