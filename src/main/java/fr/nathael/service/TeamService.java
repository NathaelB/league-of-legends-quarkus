package fr.nathael.service;

import fr.nathael.dto.TeamChampionDistribution;
import fr.nathael.dto.TeamDTO;
import fr.nathael.exception.game.GameNotStartedException;
import fr.nathael.exception.game.GameStartedException;
import fr.nathael.exception.team.TeamAlreadyExistsException;
import fr.nathael.model.Ability;
import fr.nathael.model.Champion;
import fr.nathael.model.Lanes;
import fr.nathael.model.Team;
import fr.nathael.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class TeamService {
  @Inject
  TeamRepository teamRepository;

  @Inject
  ChampionService championService;

  public Team addTeam (TeamDTO teamDTO) {
    if (teamRepository.isGameStarted()) {
      throw new GameStartedException();
    }
    if (teamRepository.teamExist(teamDTO.getName())) {
      throw new TeamAlreadyExistsException("Team with name " + teamDTO.getName() + " already exists");
    }
    if (teamRepository.findAll().size() >= 2) {
      throw new TeamAlreadyExistsException("Only 2 teams are allowed");
    }

    Team team = new Team();
    team.setName(teamDTO.getName());

    for (TeamChampionDistribution championDistribution : teamDTO.getChampionsDistribution()) {
      Champion champion = championService.getChampion(championDistribution.getChampionName());
      team.addChampion(champion, championDistribution.getLane());
    }
    teamRepository.addTeam(team);

    return team;
  }

  public List<Team> getTeams () {
    return teamRepository.findAll();
  }

  public void setTeams (ArrayList<Team> teams) {
    teamRepository.setTeams(teams);
  }

  public void activeGame () {
    teamRepository.setGameStarted(true);
  }

  public boolean isGameStarted () {
    return teamRepository.isGameStarted();
  }

  public List<LaneResult> predictLaneWinners () {
    if (!isGameStarted()) {
      throw new GameNotStartedException();
    }

    Team blueTeam = teamRepository.findAll().get(0);
    Team redTeam = teamRepository.findAll().get(1);

    List<LaneResult> results = new ArrayList<>();

    for (Lanes lane : Lanes.values()) {
      Champion blueChampion = blueTeam.getChampionsMap().get(lane);
      Champion redChampion = redTeam.getChampionsMap().get(lane);


      if (blueChampion != null && redChampion != null) {
        String winningTeam = determineWinner(blueChampion, redChampion);
        results.add(new LaneResult(lane.name(), winningTeam));
      }
    }

    return results;
  }

  private String determineWinner (Champion blueChampion, Champion redChampion) {
    Ability blueChampionAbility = blueChampion.getAbilities().stream().max(Comparator.comparingInt(Ability::getDamage)).orElse(null);
    Ability redChampionAbility = redChampion.getAbilities().stream().max(Comparator.comparingInt(Ability::getDamage)).orElse(null);

    if (blueChampionAbility == null || redChampionAbility == null) {
      return "UNKNOWN";
    }

    int blueHitsToKill = (int) Math.ceil((double) redChampion.getLifePoints() / blueChampionAbility.getDamage());
    int redHitsToKill = (int) Math.ceil((double) blueChampion.getLifePoints() / redChampionAbility.getDamage());

    return blueHitsToKill <= redHitsToKill ? "BLUE" : "RED";
  }

  public static class LaneResult {
    private String laneName;
    private String winningTeam;

    public LaneResult (String laneName, String winningTeam) {
      this.laneName = laneName;
      this.winningTeam = winningTeam;
    }

    public String getLaneName () {
      return laneName;
    }

    public void setLaneName (String laneName) {
      this.laneName = laneName;
    }

    public String getWinningTeam () {
      return winningTeam;
    }

    public void setWinningTeam (String winningTeam) {
      this.winningTeam = winningTeam;
    }
  }
}
