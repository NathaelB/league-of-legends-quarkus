package fr.nathael.service;

import fr.nathael.dto.ChampionDTO;
import fr.nathael.exception.ChampionAlreadyExistsException;
import fr.nathael.model.Champion;
import fr.nathael.repository.ChampionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ChampionService {
  @Inject
  ChampionRepository championRepository;

  private void addChampion (Champion champion) {
    championRepository.addChampion(champion);
  }

  public List<Champion> getChampions (String type, String lane) {
    return championRepository.findAll().stream()
        .filter(champion -> (type == null || champion.getChampionType().name().equals(type)) &&
            (lane == null || champion.getLane().name().equals(lane)))
        .collect(Collectors.toList());
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

  public void update (String name, Champion champion) {
    championRepository.updateChampion(name, champion);
  }
}
