package fr.nathael.model;

public class Ability {
  private String abilityName;
  private int damage;

  public Ability (String abilityName, int damage) {
    this.abilityName = abilityName;
    this.damage = damage;
  }

  public String getAbilityName () {
    return abilityName;
  }

  public void setAbilityName (String abilityName) {
    this.abilityName = abilityName;
  }

  public int getDamage () {
    return damage;
  }

  public void setDamage (int damage) {
    this.damage = damage;
  }
}
