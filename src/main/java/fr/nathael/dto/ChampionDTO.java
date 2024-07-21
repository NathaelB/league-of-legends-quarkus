package fr.nathael.dto;

import fr.nathael.model.Ability;
import fr.nathael.model.Lanes;
import fr.nathael.model.Roles;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChampionDTO {
  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotNull(message = "Champion type is mandatory")
  private Roles championType;

  @Min(value = 100, message = "Life points must be at least 100")
  @Max(value = 150, message = "Life points must be no more than 150")
  private int lifePoints;

  @NotNull(message = "Lane is mandatory")
  private Lanes lane;

  @NotNull(message = "Abilities are mandatory")
  private List<Ability> abilities = new ArrayList<>();

  // Getters and Setters
  public String getName () {
    return name;
  }


  public void setName (String name) {
    this.name = name;
  }

  public Roles getChampionType () {
    return championType;
  }

  public void setChampionType (Roles championType) {
    this.championType = championType;
  }

  public int getLifePoints () {
    return lifePoints;
  }

  public void setLifePoints (int lifePoints) {
    this.lifePoints = lifePoints;
  }

  public Lanes getLane () {
    return lane;
  }

  public void setLane (Lanes lane) {
    this.lane = lane;
  }

  public List<Ability> getAbilities () {
    return abilities;
  }

  public void setAbilities (List<Ability> abilities) {
    this.abilities = abilities;
  }
}
