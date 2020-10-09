package com.football.repository;

import com.football.domain.Player;
import com.football.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {


    List<Player> findByLastnameLike(String name);

    List<Player> findByFirstnameLike(String name);
}
