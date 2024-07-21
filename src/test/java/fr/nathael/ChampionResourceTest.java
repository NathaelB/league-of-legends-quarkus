package fr.nathael;

import fr.nathael.dto.ChampionDTO;
import fr.nathael.dto.ChampionUpdateDTO;
import fr.nathael.model.Ability;
import fr.nathael.model.Lanes;
import fr.nathael.model.Roles;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

@QuarkusTest
class ChampionResourceTest {
  @Test
  public void testGetChampionsEndpoint () {
    given()
        .when().get("/champions")
        .then()
        .statusCode(200)
        .contentType(MediaType.APPLICATION_JSON);
  }

  @Test
  public void testAddChampionEndpoint () {
    ChampionDTO championDTO = new ChampionDTO();
    championDTO.setName("Aatrox");
    championDTO.setLane(Lanes.TOP);
    championDTO.setChampionType(Roles.COMBATTANT);
    championDTO.setLifePoints(150);
    ArrayList<Ability> abilities = new ArrayList<>();
    abilities.add(new Ability("Blood Well", 200, 300));
    championDTO.setAbilities(abilities);

    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(championDTO)
        .when().post("/champions")
        .then()
        .statusCode(201)
        .contentType(MediaType.APPLICATION_JSON);
  }

  @Test
  public void testUpdateChampionEndpoint () {
    ChampionUpdateDTO championUpdateDTO = new ChampionUpdateDTO();
    championUpdateDTO.setName("Jinx");

    given()
        .contentType(MediaType.APPLICATION_JSON)
        .body(championUpdateDTO)
        .when().put("/champions/Aatrox")
        .then()
        .statusCode(200);
  }
}
