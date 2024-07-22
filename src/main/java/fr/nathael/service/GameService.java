package fr.nathael.service;

import fr.nathael.exception.game.GameNotStartedException;
import fr.nathael.exception.game.GameStartedException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GameService {

  @Inject
  TeamService teamService;

  public void beginGame () {
    if (teamService.isGameStarted()) {
      throw new GameStartedException();
    }
    teamService.activeGame();
  }

  public List<TeamService.LaneResult> predicateGame () {
    if (!teamService.isGameStarted()) {
      throw new GameNotStartedException();
    }
    return teamService.predictLaneWinners();
  }
}
