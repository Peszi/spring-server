package com.shutter.springserver.repository;

import com.shutter.springserver.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
