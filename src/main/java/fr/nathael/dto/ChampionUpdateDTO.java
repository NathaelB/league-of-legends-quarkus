package fr.nathael.dto;

import fr.nathael.model.Ability;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.ArrayList;
import java.util.List;

public class ChampionUpdateDTO {
  private String name;
  @Min(value = 100, message = "Life points must be at least 100")
  @Max(value = 150, message = "Life points must be no more than 150")
  private int lifePoints;

  @Nullable()
  private List<Ability> abilities = new ArrayList<>();

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public int getLifePoints () {
    return lifePoints;
  }

  public void setLifePoints (int lifePoints) {
    this.lifePoints = lifePoints;
  }

  @Nullable
  public List<Ability> getAbilities () {
    return abilities;
  }

  public void setAbilities (List<Ability> abilities) {
    this.abilities = abilities;
  }
}
