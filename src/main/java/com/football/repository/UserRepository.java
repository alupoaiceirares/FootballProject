package com.football.repository;

import com.football.domain.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByLastnameLike(String lastname);
}
