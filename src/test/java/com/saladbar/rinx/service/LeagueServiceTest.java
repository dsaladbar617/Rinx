package com.saladbar.rinx.service;

import com.saladbar.rinx.exception.ResourceNotFoundException;
import com.saladbar.rinx.league.repository.LeagueRepository;
import com.saladbar.rinx.league.service.LeagueServiceImpl;
import com.saladbar.rinx.model.entity.League;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class LeagueServiceTest {

    @Mock
    private LeagueRepository leagueRepository;
    @InjectMocks
    private LeagueServiceImpl leagueService;

    private League league;

    @BeforeEach
    public void setup() {
        league = new League.Builder()
                .leagueId(1L)
                .leagueName("test")
                .build();
    }

    @Test
    public void saveLeagueTest() {
        given(leagueRepository.findByLeagueName(league.getLeagueName())).willReturn(Optional.empty());

        given(leagueRepository.save(league)).willReturn(league);

        League savedLeague = leagueService.save(league);

        assertThat(savedLeague).isNotNull();
    }

    @Test
    public void saveFailLeagueTest() {
        given(leagueRepository.findByLeagueName(league.getLeagueName())).willReturn(Optional.of(league));
        assertThrows(ResourceNotFoundException.class, () -> leagueService.save(league));
        verify(leagueRepository, never()).save(any(League.class));
    }

    @Test
    public void getAllLeaguesTest() {
        League league1 = new League.Builder()
                .leagueId(2L)
                .leagueName("test1")
                .build();

        given(leagueRepository.findAll()).willReturn(List.of(league, league1));

        List<League> leagueList = leagueRepository.findAll();

        assertThat(leagueList).isNotNull();
        assertThat(leagueList.size()).isEqualTo(2);
    }

    @Test
    public void getEmptyAllLeaguesTest() {
        given(leagueRepository.findAll()).willReturn(Collections.emptyList());
        List<League> leagueList = leagueRepository.findAll();
        assertThat(leagueList).isEmpty();
    }

    @Test
    public void getLeagueByIdTest() {
        given(leagueRepository.findById(league.getLeagueId())).willReturn(Optional.of(league));

        League foundLeague = leagueRepository.findById(league.getLeagueId()).get();

        assertThat(foundLeague).isNotNull();
    }

    @Test
    public void getFailedLeagueByIdTest() {
        given(leagueRepository.findById(1L)).willReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> leagueService.findById(league.getLeagueId()));
    }

    @Test
    public void updateLeagueTest() {
        given(leagueRepository.save(league)).willReturn(league);
        league.setLeagueName("DeezNutz");

        League updatedLeague = leagueService.updateLeague(league);

        assertThat(updatedLeague.getLeagueName()).isEqualTo("DeezNutz");
    }

    @Test
    public void deleteLeagueTest() {
        willDoNothing().given(leagueRepository).delete(league);
        leagueService.delete(league);
        verify(leagueRepository, times(1)).delete(league);
    }

}
