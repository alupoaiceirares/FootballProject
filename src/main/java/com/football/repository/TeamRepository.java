package com.football.repository;

import com.football.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {

    List<Team> findByNameLike(String name);
}
