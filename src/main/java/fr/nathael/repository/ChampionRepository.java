package fr.nathael.repository;

import fr.nathael.model.Champion;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ChampionRepository {
    private final List<Champion> champions = new ArrayList<>();

    public void addChampion(Champion champion) {
        champions.add(champion);
    }

    public List<Champion> findAll() {
        return champions;
    }

    public Optional<Champion> findByName(String name) {
        return champions.stream()
                .filter(champion -> champion.getName().toLowerCase().equalsIgnoreCase(name))
                .findFirst();
    }
}
