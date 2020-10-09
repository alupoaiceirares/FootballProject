package com.football.repository;

import com.football.domain.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Integer> {

    List<Match> findByTeam1Equals(String team1);

    List<Match> findByTeam2Equals(String team2);

    Match findById (int id);
}
