package com.football.repository;

import com.football.domain.League;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueRepository extends CrudRepository<League, Integer> {


    List<League> findByNameLike(String name);
}
