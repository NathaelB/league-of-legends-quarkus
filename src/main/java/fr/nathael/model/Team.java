package fr.nathael.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Team {
  private final Map<String, Champion> champions = new ConcurrentHashMap<>();
  private String name;

  public Team () {
  }

  public String getName () {
    return name;
  }

  public void setName (String name) {
    this.name = name;
  }

  public ArrayList<Champion> getChampions () {
    return new ArrayList<>(champions.values());
  }

  public void addChampion (Champion champion) {
    champions.put(champion.getName(), champion);
  }
}
