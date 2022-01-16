package com.game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.game.model.Team;
import com.game.repository.TeamRepository;


@RestController
@RequestMapping("/api/v1")
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	@GetMapping("/teams")
	public List<Team> findAllTeams(){
		return teamRepository.findAll();
	}
	
	@GetMapping("/teams/{id}")
	public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Integer teamId) throws ResourceNotFoundException {
		Team user = teamRepository.findById(teamId)
	            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + teamId));
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping("/teams")
	public Team addTeam(@Validated @RequestBody Team team) {
		return teamRepository.save(team);
	}


	@PutMapping("/teams/{id}")
	public ResponseEntity <Team> updateUser(
	        @PathVariable(value = "id") Integer teamId,
	        @Validated @RequestBody Team teamDetails) throws ResourceNotFoundException {
	        Team user = teamRepository.findById(teamId)
	            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + teamId));
	        user.setTeamLocation(teamDetails.getTeamLocation());
	        final Team updatedUser = teamRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }
	
	
	@DeleteMapping("/teams/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Integer teamId) throws ResourceNotFoundException {
        Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + teamId));

        teamRepository.deleteById(teamId);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	
	
	 
	 
	 
	
	
	
	
	
}
