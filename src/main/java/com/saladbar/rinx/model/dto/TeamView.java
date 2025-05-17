package com.saladbar.rinx.model.dto;

import java.util.List;

public interface TeamView {
    long getTeamId();
    String getTeamName();
    LeagueView getLeague();
    List<SkaterView> getSkaters();
    List<GoalieView> getGoalies();

    interface LeagueView {
        long getLeagueId();
        String getLeagueName();
    }

    interface SkaterView {
        long getSkaterId();
        MemberView getMember();
    }

    interface GoalieView {
        long getGoalieId();
        MemberView getMember();
    }

}
