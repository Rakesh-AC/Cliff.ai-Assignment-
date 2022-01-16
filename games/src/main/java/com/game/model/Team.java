package com.game.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	private String teamName;
	private String teamLocation;
	private String created_at;
	private String updated_at;
	
	 @OneToMany(mappedBy = "instructor", cascade = {
		        CascadeType.ALL
		    })
		    private List <Player> players;

	 
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}


	Team( String teamName, String teamLocation, String created_at, String updated_at) {
		super();
		this.teamName = teamName;
		this.teamLocation = teamLocation;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getTeamLocation() {
		return teamLocation;
	}


	public void setTeamLocation(String teamLocation) {
		this.teamLocation = teamLocation;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public String getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
	

	
	
	
	
	
	
	
}
