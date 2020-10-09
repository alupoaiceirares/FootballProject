package com.football.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int points;

    @OneToMany(mappedBy = "team")
    private List<Player> playerList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TEAM_MATCH", joinColumns = {
            @JoinColumn(name = "TEAM_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "MATCH_ID", referencedColumnName = "id")
            })
    private List<Match> MatchesPlayed;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    public Team() {
    }

    public Team(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Match> getMatchesPlayed() {
        return MatchesPlayed;
    }

    public void setMatchesPlayed(List<Match> matchesPlayed) {
        MatchesPlayed = matchesPlayed;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
