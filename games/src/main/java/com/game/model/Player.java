package com.game.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Player extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int playerId;
	
	
	private String playerName;
	
	private int playerAge;
	
	private String created_At;
	
	private String updated_At;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "team_id")
	private Team team;


	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}


	Player(String playerName, int playerAge, String created_At, String updated_At) {
		super();
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}


	public int getPlayerId() {
		return playerId;
	}


	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public int getPlayerAge() {
		return playerAge;
	}


	public void setPlayerAge(int playerAge) {
		this.playerAge = playerAge;
	}


	public String getCreated_At() {
		return created_At;
	}


	public void setCreated_At(String created_At) {
		this.created_At = created_At;
	}


	public String getUpdated_At() {
		return updated_At;
	}


	public void setUpdated_At(String updated_At) {
		this.updated_At = updated_At;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	
	

}
