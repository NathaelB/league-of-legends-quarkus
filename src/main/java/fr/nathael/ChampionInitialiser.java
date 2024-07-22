package fr.nathael;

import fr.nathael.dto.TeamChampionDistribution;
import fr.nathael.dto.TeamDTO;
import fr.nathael.model.Ability;
import fr.nathael.model.Lanes;
import fr.nathael.model.Roles;
import fr.nathael.service.ChampionService;
import fr.nathael.service.TeamService;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ChampionInitialiser {
  @Inject
  ChampionService championService;

  @Inject
  TeamService teamService;

  public void onStart (@Observes StartupEvent ev) {
    initChampions();
    initTeams();
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

  private void initTeams () {
    TeamDTO team1 = new TeamDTO();
    team1.setName("BLEU");
    team1.addChampionDistribution(new TeamChampionDistribution("Aatrox", Lanes.TOP));
    team1.addChampionDistribution(new TeamChampionDistribution("Ahri", Lanes.MID));
    team1.addChampionDistribution(new TeamChampionDistribution("Akali", Lanes.ADC));
    team1.addChampionDistribution(new TeamChampionDistribution("Alistar", Lanes.SUPPORT));
    team1.addChampionDistribution(new TeamChampionDistribution("Amumu", Lanes.JUNGLE));

    TeamDTO team2 = new TeamDTO();
    team2.setName("RED");
    team2.addChampionDistribution(new TeamChampionDistribution("Annie", Lanes.TOP));
    team2.addChampionDistribution(new TeamChampionDistribution("Ashe", Lanes.ADC));
    team2.addChampionDistribution(new TeamChampionDistribution("Aurelion Sol", Lanes.MID));
    team2.addChampionDistribution(new TeamChampionDistribution("Azir", Lanes.MID));
    team2.addChampionDistribution(new TeamChampionDistribution("Aatrox", Lanes.SUPPORT));

    teamService.addTeam(team1);
    teamService.addTeam(team2);
  }
}
