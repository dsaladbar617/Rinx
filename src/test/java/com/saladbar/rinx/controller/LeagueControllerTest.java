package com.saladbar.rinx.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saladbar.rinx.config.SpringSecurityConfig;
import com.saladbar.rinx.league.controller.LeagueController;
import com.saladbar.rinx.league.service.LeagueService;
import com.saladbar.rinx.model.dto.LeagueView;
import com.saladbar.rinx.model.dto.test.LeagueViewTest;
import com.saladbar.rinx.model.entity.League;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(LeagueController.class)
@Import(SpringSecurityConfig.class)
@WithMockUser(username = "username", password = "password")
public class LeagueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeagueService leagueService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createLeagueTest() throws Exception {
        LeagueViewTest league = new LeagueViewTest.Builder()
                .leagueId(1)
                .leagueName("test")
                .build();

        given(leagueService.save(any(League.class)))
                .willAnswer( (invocationOnMock) -> invocationOnMock.getArgument(0));

        given(leagueService.findTeamViewById(league.getLeagueId())).willReturn(Optional.of(league));

        ResultActions response = mockMvc.perform(post("/leagues")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(league)));

        response.andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.leagueName",
                        is(league.getLeagueName())));
    }

    @Test
    public void getAllLeaguesTest() throws Exception {
        Set<LeagueView> leagueSet = new HashSet<>(Arrays.asList(
                new LeagueViewTest(1, "test", null),
                new LeagueViewTest(2, "test1", null),
                new LeagueViewTest(3, "test3", null)
        ));

        given(leagueService.findAllLeagueViews()).willReturn(leagueSet);

        ResultActions response = mockMvc.perform(get("/leagues")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(leagueSet)));

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",
                        is(leagueSet.size())));

    }

    @Test
    public void getLeagueByIdTest() throws Exception {
        LeagueViewTest league = new LeagueViewTest.Builder()
                .leagueName("test")
                .leagueId(1L)
                .teams(null)
                .build();

        given(leagueService.findTeamViewById(league.getLeagueId())).willReturn(Optional.of(league));

        ResultActions response = mockMvc.perform(get("/leagues/{id}", league.getLeagueId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(league)));

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.leagueName", is(league.getLeagueName())));
    }

    @Test
    public void getLeagueByIdFailTest() throws Exception {
        LeagueViewTest league = new LeagueViewTest.Builder()
                .leagueName("test")
                .leagueId(1L)
                .teams(null)
                .build();

        given(leagueService.findTeamViewById(league.getLeagueId())).willReturn(Optional.empty());

        ResultActions response = mockMvc.perform(get("/leagues/{id}", league.getLeagueId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(league)));

        response.andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteLeagueTest() throws Exception {
        League league = new League.Builder()
                .leagueName("test")
                .leagueId(1L)
                .teams(null)
                .build();

        willDoNothing().given(leagueService).delete(league);

        ResultActions response = mockMvc.perform(delete("/leagues/{id}",
                league.getLeagueId()));

        response.andDo(print())
                .andExpect(status().isNoContent());
    }
}
