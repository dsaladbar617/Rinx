package com.saladbar.rinx.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "game")
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "rink_id")
    private Rink rink;

    @Column(name = "game_date")
    private LocalDateTime gameDate;

//    @Column(name)
    private int homeScore;

    private int awayScore;

    public Game() {
    }

    public Game(long gameId, Team homeTeam, Team awayTeam, Rink rink, LocalDateTime gameDate, int homeScore, int awayScore) {
        this.gameId = gameId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.rink = rink;
        this.gameDate = gameDate;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Rink getRink() {
        return rink;
    }

    public void setRink(Rink rink) {
        this.rink = rink;
    }

    public LocalDateTime getGameDate() {
        return gameDate;
    }

    public void setGameDate(LocalDateTime gameDate) {
        this.gameDate = gameDate;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Game{");
        sb.append("gameId=").append(gameId);
        sb.append(", homeTeam=").append(homeTeam);
        sb.append(", awayTeam=").append(awayTeam);
        sb.append(", rink=").append(rink);
        sb.append(", gameDate=").append(gameDate);
        sb.append(", homeScore=").append(homeScore);
        sb.append(", awayScore=").append(awayScore);
        sb.append('}');
        return sb.toString();
    }
}
