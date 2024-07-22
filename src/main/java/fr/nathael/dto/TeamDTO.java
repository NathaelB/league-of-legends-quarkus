package fr.nathael.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class TeamDTO {
  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotNull(message = "Champions distribution is mandatory")
  private ArrayList<TeamChampionDistribution> championsDistribution;

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public ArrayList<TeamChampionDistribution> getChampionsDistribution () {
    return championsDistribution;
  }

  public void setChampionsDistribution (ArrayList<TeamChampionDistribution> championsDistribution) {
    this.championsDistribution = championsDistribution;
  }
}
