package com.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.game.model.Player;
import com.game.repository.PlayerRepository;
import com.game.repository.TeamRepository;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {
	
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerRepository playerRepository;
	 
	 
	@GetMapping("/teams/{teamId}/players")
	public List <Player> getCoursesByInstructor(@PathVariable(value = "postId") Integer teamId) {
		return playerRepository.findByInstructorId(teamId);
	}
	
	@PostMapping("/teams/{teamId}/players")
    public Player addPlayer(@PathVariable(value = "teamId") Integer teamId,
        @Validated @RequestBody Player player) throws ResourceNotFoundException {
        return teamRepository.findById(teamId).map(team -> {
            player.setTeam(team);
            return playerRepository.save(player);
        }).orElseThrow(() -> new ResourceNotFoundException("Team not found"));
    }
	
	
	@PutMapping("/teams/{teamId}/players/{playerId}")
    public Player updatePlayer(@PathVariable(value = "teamId") Integer teamId,
        @PathVariable(value = "courseId") Integer playerId, @Validated @RequestBody Player playerRequest)
    throws ResourceNotFoundException {
        if (!teamRepository.existsById(teamId)) {
            throw new ResourceNotFoundException("instructorId not found");
        }

        return playerRepository.findById(playerId).map(player -> {
            player.setPlayerAge(playerRequest.getPlayerAge());
            return playerRepository.save(player);
        }).orElseThrow(() -> new ResourceNotFoundException("course id not found"));
    }
	
	
	@DeleteMapping("/teams/{teamId}/players/{playerId}")
    public ResponseEntity < ? > deletePlayer(@PathVariable(value = "TeamId") Integer teamId,
        @PathVariable(value = "playerId") Integer playerId) throws ResourceNotFoundException {
        return teamRepository.findByIdAndTeamId(playerId, teamId).map(player -> {
            playerRepository.deleteById(playerId);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
            "Course not found with id " + playerId + " and instructorId " + teamId));
    }
	
	
	
	
	
	
	
}
