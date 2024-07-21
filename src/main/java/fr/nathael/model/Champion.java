package fr.nathael.model;

import java.util.List;

public class Champion {
  private String name;
  private Roles championType;
  private int lifePoints;
  private List<Ability> abilities;
  private Lanes lane;

  public Champion (String championName, Roles championType, int lifePoints, List<Ability> abilities, Lanes lane) {
    setChampionName(championName);
    this.championType = championType;
    setLifePoints(lifePoints);
    this.abilities = abilities;
    this.lane = lane;
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public void setChampionName (String championName) {
    this.name = championName.substring(0, 1).toUpperCase() + championName.substring(1).toLowerCase();
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
    if (lifePoints >= 100 && lifePoints <= 150) {
      this.lifePoints = lifePoints;
    } else {
      throw new IllegalArgumentException("Life points must be between 100 and 150.");
    }
  }

  public List<Ability> getAbilities () {
    return abilities;
  }

  public void setAbilities (List<Ability> abilities) {
    this.abilities = abilities;
  }

  public Lanes getLane () {
    return lane;
  }

  public void setLane (Lanes lane) {
    this.lane = lane;
  }
}