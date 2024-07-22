package fr.nathael.repository;

import fr.nathael.model.Team;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TeamRepository {
  private final List<Team> teams = new ArrayList<>();

  public void addTeam (Team team) {
    teams.add(team);
  }

  public List<Team> findAll () {
    return teams;
  }
}
