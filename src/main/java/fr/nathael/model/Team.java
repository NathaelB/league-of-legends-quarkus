package fr.nathael.model;

import fr.nathael.exception.team.TeamFullCapacityException;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Team {
  private final Map<Lanes, Champion> champions = new ConcurrentHashMap<>();
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

  public Map<Lanes, Champion> getChampionsMap () {
    return champions;
  }

  public void addChampion (Champion champion, Lanes lane) {
    ArrayList<Champion> championArrayList = getChampions();
    if (championArrayList.contains(champion)) {
      throw new TeamFullCapacityException("Champion " + champion.getName() + " is already in the team");
    }
    
    champions.put(lane, champion);
  }
}
