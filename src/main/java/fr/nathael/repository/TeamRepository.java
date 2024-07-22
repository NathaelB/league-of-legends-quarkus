package fr.nathael.repository;

import fr.nathael.model.Team;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeamRepository {
  private final List<Team> teams = new ArrayList<>();
  private boolean gameStarted = false;

  public void addTeam (Team team) {
    teams.add(team);
  }

  public boolean isGameStarted () {
    return gameStarted;
  }

  public void setGameStarted (boolean gameStarted) {
    this.gameStarted = gameStarted;
  }

  public List<Team> findAll () {
    return teams;
  }

  public boolean teamExist (String name) {
    return teams.stream()
        .anyMatch(team -> team.getName().equalsIgnoreCase(name));
  }

  public void setTeams (ArrayList<Team> teams) {
    this.teams.clear();
    this.teams.addAll(teams);
  }
}
