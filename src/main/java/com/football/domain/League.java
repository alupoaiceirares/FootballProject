/*package com.fotbal.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int noOfTeams;

    private String country;

    @OneToMany(mappedBy = "league")
    private List<Round> roundsList;

    @OneToMany(mappedBy = "league")
    private List<Team> teamList;

    public League() {
    }

    public League(String name, int noOfTeams, String country) {
        this.name = name;
        this.noOfTeams = noOfTeams;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfTeams() {
        return noOfTeams;
    }

    public void setNoOfTeams(int noOfTeams) {
        this.noOfTeams = noOfTeams;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Round> getRoundsList() {
        return roundsList;
    }

    public void setRoundsList(List<Round> roundsList) {
        this.roundsList = roundsList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}*/
package com.football.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private long noOfTeams;

    private String country;

    private long noOfRounds;

    @OneToMany(mappedBy = "league")
    private List<Team> teamList;

    public League() {
    }

    public League(String name, int noOfTeams, String country) {
        this.name = name;
        this.noOfTeams = noOfTeams;
        this.country = country;
    }

    public League(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNoOfTeams() {
        return noOfTeams;
    }

    public void setNoOfTeams(long noOfTeams) {
        this.noOfTeams = noOfTeams;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getNoOfRounds() {
        return noOfRounds;
    }

    public void setNoOfRounds(long noOfRounds) {
        this.noOfRounds = noOfRounds;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}

