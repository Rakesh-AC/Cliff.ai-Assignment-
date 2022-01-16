package com.game.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.model.Player;
import com.game.model.Team;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	
	List<Player> findByInstructorId(Integer teamId);
	Optional<Team> findByIdAndInstructorId(int id, int teamId);
}
