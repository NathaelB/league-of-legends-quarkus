package fr.nathael.service;

import fr.nathael.dto.TeamChampionDistribution;
import fr.nathael.dto.TeamDTO;
import fr.nathael.model.Champion;
import fr.nathael.model.Team;
import fr.nathael.repository.TeamRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TeamService {
  @Inject
  TeamRepository teamRepository;

  @Inject
  ChampionService championService;

  public Team addTeam (TeamDTO teamDTO) {
    Team team = new Team();
    team.setName(teamDTO.getName());

    for (TeamChampionDistribution championDistribution : teamDTO.getChampionsDistribution()) {
      Champion champion = championService.getChampion(championDistribution.getChampionName());
      team.addChampion(champion);
    }
    teamRepository.addTeam(team);

    return team;
  }

  public List<Team> getTeams () {
    return teamRepository.findAll();
  }
}
