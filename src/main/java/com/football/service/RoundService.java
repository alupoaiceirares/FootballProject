package com.football.service;

import com.football.domain.Match;
import com.football.domain.Round;
import com.football.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoundService {

    @Autowired
    RoundRepository roundRepository;

    public void createRound(Round round){

        List<Match> matches = new ArrayList<>();
        round.setMatches(matches);
        int roundNO = round.getRoundNumber();
        roundNO = roundNO +1 ;
        round.setRoundNumber(roundNO);
        roundRepository.save(round);

    }

    public void updateRound(Round round, Match match){
        List<Match> matches = round.getMatches();
        matches.add(match);
        round.setMatches(matches);


        roundRepository.save(round);

    }

    //functie ptr end round
}
