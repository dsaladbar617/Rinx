package com.saladbar.rinx.team.repository;

import com.saladbar.rinx.model.dto.TeamView;
import com.saladbar.rinx.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Long> {
    TeamView findTeamViewByTeamId(long id);
    Set<TeamView> findAllBy();
}
