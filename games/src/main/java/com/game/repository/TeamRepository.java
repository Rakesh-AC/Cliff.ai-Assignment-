package com.game.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	Optional<Team> findByIdAndTeamId(Integer playerId, Integer teamId);

}
