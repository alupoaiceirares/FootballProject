package com.football.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Game")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String team1;

    private String team2;

    private int scoreT1;

    private int scoreT2;

    @ManyToMany(mappedBy = "MatchesPlayed", fetch = FetchType.EAGER)
    private List<Team> MatchTeamList;


    @ManyToOne
    @JoinColumn(name = "round_id")
    private Round round;

    public Match() {
    }

    public Match(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public List<Team> getMatchTeamList() {
        return MatchTeamList;
    }

    public void setMatchTeamList(List<Team> matchTeamList) {
        MatchTeamList = matchTeamList;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getScoreT1() {
        return scoreT1;
    }

    public void setScoreT1(int scoreT1) {
        this.scoreT1 = scoreT1;
    }

    public int getScoreT2() {
        return scoreT2;
    }

    public void setScoreT2(int scoreT2) {
        this.scoreT2 = scoreT2;
    }

    public int getId() {
        return id;
    }
}
