package fr.nathael;

import fr.nathael.model.Ability;
import fr.nathael.model.Lanes;
import fr.nathael.model.Roles;
import fr.nathael.service.ChampionService;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ChampionInitialiser {
  @Inject
  ChampionService championService;

  public void onStart (@Observes StartupEvent ev) {
    initChampions();
  }

  private void initChampions () {
    if (championService.getChampions().isEmpty()) {
      championService.addChampion(
          "Aatrox",
          Roles.COMBATTANT,
          150,
          List.of(new Ability("The Darkin Blade", 80, 15)),
          Lanes.TOP
      );
      championService.addChampion(
          "Ahri",
          Roles.MAGE,
          100,
          List.of(new Ability("Orb of Deception", 70, 7)),
          Lanes.MID
      );
      championService.addChampion(
          "Akali",
          Roles.ASSASSIN,
          100,
          List.of(new Ability("Five Point Strike", 60, 10)),
          Lanes.TOP
      );
      championService.addChampion(
          "Alistar",
          Roles.TANK,
          150,
          List.of(new Ability("Pulverize", 50, 13)),
          Lanes.SUPPORT
      );
      championService.addChampion(
          "Amumu",
          Roles.TANK,
          140,
          List.of(new Ability("Bandage Toss", 90, 18)),
          Lanes.JUNGLE
      );
      championService.addChampion(
          "Anivia",
          Roles.MAGE,
          120,
          List.of(new Ability("Flash Frost", 85, 12)),
          Lanes.MID
      );
      championService.addChampion(
          "Annie",
          Roles.MAGE,
          134,
          List.of(new Ability("Disintegrate", 75, 8)),
          Lanes.MID
      );
      championService.addChampion(
          "Ashe",
          Roles.TIREUR,
          100,
          List.of(new Ability("Ranger's Focus", 65, 14)),
          Lanes.ADC
      );
      championService.addChampion(
          "Aurelion Sol",
          Roles.MAGE,
          135,
          List.of(new Ability("Starsurge", 80, 10)),
          Lanes.MID
      );
      championService.addChampion(
          "Azir",
          Roles.MAGE,
          105,
          List.of(new Ability("Conquering Sands", 70, 9)),
          Lanes.MID
      );
    }
  }
}
