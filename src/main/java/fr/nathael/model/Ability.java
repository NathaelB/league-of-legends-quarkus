package fr.nathael.model;

public class Ability {
  private String abilityName;
  private int damage;
  private int cooldown;

  public Ability (String abilityName, int damage, int cooldown) {
    this.abilityName = abilityName;
    this.damage = damage;
    this.cooldown = cooldown;
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

  public int getCooldown () {
    return cooldown;
  }

  public void setCooldown (int cooldown) {
    this.cooldown = cooldown;
  }
}
