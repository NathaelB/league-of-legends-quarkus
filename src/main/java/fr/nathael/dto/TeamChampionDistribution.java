package fr.nathael.dto;

import fr.nathael.model.Lanes;
import jakarta.validation.constraints.NotBlank;

public class TeamChampionDistribution {
  @NotBlank(message = "Team name is mandatory")
  private String championName;

  @NotBlank(message = "Lane is mandatory")
  private Lanes lane;

  public String getChampionName () {
    return championName;
  }

  public void setChampionName (String championName) {
    this.championName = championName;
  }

  public Lanes getLane () {
    return lane;
  }

  public void setLane (Lanes lane) {
    this.lane = lane;
  }
}
