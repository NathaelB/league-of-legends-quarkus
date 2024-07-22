package fr.nathael.service;

import fr.nathael.dto.ChampionDTO;
import fr.nathael.dto.ChampionUpdateDTO;
import fr.nathael.exception.ChampionAlreadyExistsException;
import fr.nathael.exception.ChampionNotFoundException;
import fr.nathael.model.Ability;
import fr.nathael.model.Champion;
import fr.nathael.model.Lanes;
import fr.nathael.model.Roles;
import fr.nathael.repository.ChampionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ChampionService {
  @Inject
  ChampionRepository championRepository;

  public void addChampion (String name, Roles role, int lifePoints, List<Ability> abilities, Lanes lane) {
    Champion c = new Champion(name, role, lifePoints, abilities, lane);
    championRepository.addChampion(c);
  }

  public List<Champion> getChampions () {
    return championRepository.findAll();
  }

  public List<Champion> getChampions (String type, String lane) {
    return championRepository.findAll().stream()
        .filter(champion -> (type == null || champion.getChampionType().name().equals(type)) &&
            (lane == null || champion.getLane().name().equals(lane)))
        .collect(Collectors.toList());
  }

  public Champion getChampion (String name) {
    return championRepository.findByName(name)
        .orElseThrow(() -> new ChampionNotFoundException("Champion with name " + name + " not found"));
  }

  public Champion create (ChampionDTO championDTO) {
    if (championRepository.findByName(championDTO.getName()).isPresent()) {
      throw new ChampionAlreadyExistsException("A champion with the same name already exists.");
    }
    //Champion champion = new Champion(championDTO.getName(), championDTO.getChampionType(), championDTO.getLifePoints(), new ArrayList<>(), championDTO.getLane());
    //addChampion(champion);
    return championRepository.createChampion(championDTO);
  }

  public void delete (String name) {
    championRepository.deleteChampion(name);
  }

  public Champion update (String name, ChampionUpdateDTO championUpdateDTO) {
    Champion champion = championRepository.findByName(name)
        .orElseThrow(() -> new ChampionNotFoundException("Champion with name " + name + " not found"));

    if (championUpdateDTO.getName() != null) {
      champion.setName(championUpdateDTO.getName());
    }
    if (championUpdateDTO.getLifePoints() != 0) {
      champion.setLifePoints(championUpdateDTO.getLifePoints());
    }
    if (championUpdateDTO.getAbilities() != null && !championUpdateDTO.getAbilities().isEmpty()) {
      champion.setAbilities(championUpdateDTO.getAbilities());
    }

    return champion;
  }

  public void addChampion () {

  }
}
