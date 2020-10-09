package com.football.domain;


import javax.persistence.*;
import java.util.List;

@Entity
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int RoundNumber = 0;

    @OneToMany(mappedBy = "round")
    private List<Match> matches;

    /*@ManyToOne
    @JoinColumn(name = "league_id")
    private League league;*/


    public Round() {
    }

    public Round(int RoundNumber) {
        this.RoundNumber = RoundNumber;
    }

    public int getRoundNumber() {
        return RoundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        RoundNumber = roundNumber;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public int getId() {
        return id;
    }

    /* public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }*/
}
