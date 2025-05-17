package com.saladbar.rinx.repository;

import com.saladbar.rinx.league.repository.LeagueRepository;
import com.saladbar.rinx.model.entity.League;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest(showSql = false)
public class LeagueRepositoryTest {

    private static List<League> leagues;

    @Autowired
    private LeagueRepository leagueRepository;

    @BeforeAll
    public static void setUp() {
        League league = new League.Builder()
                .leagueName("D1")
                .teams(null)
                .build();

        League league1 = new League.Builder()
                .leagueName("D2")
                .teams(null)
                .build();

        League league2 = new League.Builder()
                .leagueName("D3")
                .teams(null)
                .build();

        leagues = new ArrayList<>(List.of(league, league1, league2));
    }

    @BeforeEach
    public void setupBeforeEach() {
        leagueRepository.saveAll(leagues);
    }

    @AfterEach
    public void cleanup() {
        leagueRepository.deleteAll();
        leagueRepository.flush();
    }

    @DisplayName("Save league test")
    @Test
    public void saveLeagueTest() {
        League league = new League.Builder()
                .leagueName("D1")
                .teams(null)
                .build();

        League savedLeague = leagueRepository.save(league);

        assertThat(savedLeague).isNotNull();
        assertThat(savedLeague.getLeagueName()).isEqualTo("D1");
    }

    @DisplayName("Get all leagues test")
    @Test
    public void getAllLeaguesTest() {
        List<League> leagues = leagueRepository.findAll();

        assertThat(leagues).isNotNull();
        assertThat(leagues.size()).isGreaterThan(0);
    }

    @DisplayName("Get league by id test")
    @Test
    public void getLeagueByIdTest() {
        League fetchedLeague = leagueRepository.findById(leagues.getFirst().getLeagueId()).orElse(null);
        assertThat(fetchedLeague).isNotNull();
        assertThat(fetchedLeague.getLeagueName()).isEqualTo("D1");
    }

    @DisplayName("Update league test")
    @Test
    public void updateLeagueTest() {
        League league = new League.Builder()
                .leagueName("D4")
                .teams(null)
                .build();

        League savedLeague = leagueRepository.save(league);


        assertThat(savedLeague).isNotNull();

        savedLeague.setLeagueName("fbgm");

        League updatedLeague = leagueRepository.save(league);
        assertThat(updatedLeague).isNotNull();
        assertThat(savedLeague.getLeagueId()).isEqualTo(updatedLeague.getLeagueId());
        assertThat(updatedLeague.getLeagueName()).isEqualTo("fbgm");
    }


}
