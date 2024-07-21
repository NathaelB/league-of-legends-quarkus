package fr.nathael.repository;

import fr.nathael.dto.ChampionDTO;
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

  public void deleteChampion (String name) {
    champions.removeIf(champion -> champion.getName().equalsIgnoreCase(name));
  }

  public void updateChampion (String name, Champion champion) {
    for (int i = 0; i < champions.size(); i++) {
      if (champions.get(i).getName().equalsIgnoreCase(name)) {
        champions.set(i, champion);
        break;
      }
    }
  }
}
