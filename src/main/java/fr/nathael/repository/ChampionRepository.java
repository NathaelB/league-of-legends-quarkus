package fr.nathael.repository;

import fr.nathael.dto.ChampionDTO;
import fr.nathael.exception.ChampionNotFoundException;
import fr.nathael.model.Champion;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ChampionRepository {
  private final List<Champion> champions = new ArrayList<>();

  public void addChampion (Champion champion) {
    champions.add(champion);
  }

  public List<Champion> findAll () {
    return champions;
  }

  public Optional<Champion> findByName (String name) {
    return champions.stream()
        .filter(champion -> champion.getName().toLowerCase().equalsIgnoreCase(name))
        .findFirst();
  }

  public Champion createChampion (ChampionDTO championDTO) {
    Champion champion = new Champion(championDTO.getName(), championDTO.getChampionType(), championDTO.getLifePoints(), championDTO.getAbilities(), championDTO.getLane());
    addChampion(champion);
    return champion;
  }

  public boolean deleteChampion (String name) {
    System.out.println("Deleting champion with name: " + name);
    boolean t = champions.removeIf(champion -> champion.getName().equalsIgnoreCase(name));
    if (!t) {
      throw new ChampionNotFoundException("Champion with name " + name + " not found");
    }
    return true;
  }

  public void updateChampion (String name, Champion champion) {
    boolean deleted = deleteChampion(name);
    if (deleted) {
      addChampion(champion);
    }

  }
}
