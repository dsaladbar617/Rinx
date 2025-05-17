package com.saladbar.rinx.repository;

import com.saladbar.rinx.model.entity.Team;
import com.saladbar.rinx.team.repository.TeamRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest(showSql = false)
public class TeamRepositoryTest {

    private static List<Team> teams;

    @Autowired
    private TeamRepository teamRepository;

    @BeforeAll
    public static void setup() {
        Team team = new Team.Builder()
                .teamName("Overlution")
                .goalies(null)
                .skaters(null)
                .league(null)
                .build();

        Team team1 = new Team.Builder()
                .teamName("Chups")
                .goalies(null)
                .skaters(null)
                .league(null)
                .build();
        Team team2 = new Team.Builder()
                .teamName("fbgms")
                .goalies(null)
                .skaters(null)
                .league(null)
                .build();

        teams = new ArrayList<>(List.of(team, team1, team2));
    }

    @BeforeEach
    public void setupBeforeEach() {
        teamRepository.saveAll(teams);
    }

    @AfterEach
    public void cleanup() {
        teamRepository.deleteAll();
        teamRepository.flush();
    }

    @DisplayName("Save a new team")
    @Test
    public void saveTeamTest() {
        Team team = new Team.Builder()
                .teamName("Overlution")
                .goalies(null)
                .skaters(null)
                .league(null)
                .build();

        Team savedTeam = teamRepository.save(team);

        assertThat(savedTeam).isNotNull();
        assertThat(savedTeam.getTeamName()).isEqualTo("Overlution");
    }

    @Test
    public void getAllTeamTest() {
        List<Team> fetchedTeams = teamRepository.findAll();

        assertThat(fetchedTeams).isNotNull();
        assertThat(fetchedTeams.size()).isGreaterThan(0);
    }

    @Test
    @Order(1)
    public void getByIdTest() {
        Team team = teamRepository.findById(teams.getFirst().getTeamId()).orElse(null);

        assertThat(team).isNotNull();
        assertThat(team.getTeamName()).isEqualTo(teams.getFirst().getTeamName());
    }

    @Test
    public void updateTeamTest() {
        Team team = new Team.Builder()
                .league(null)
                .teamName("Dingleberries")
                .skaters(null)
                .league(null)
                .goalies(null)
                .build();
        Team savedTeam = teamRepository.save(team);

        savedTeam.setTeamName("Spring");

        Team updatedTeam = teamRepository.save(savedTeam);

        assertThat(updatedTeam).isNotNull();
        assertThat(updatedTeam.getTeamName()).isEqualTo("Spring");
        assertThat(updatedTeam.getTeamId()).isEqualTo(savedTeam.getTeamId());
    }
}
