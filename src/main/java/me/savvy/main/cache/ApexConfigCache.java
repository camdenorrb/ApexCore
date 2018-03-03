package me.savvy.main.cache;

import me.savvy.ApexCore;
import me.savvy.main.utils.Utils;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ApexConfigCache {

  private final ApexCore apexCore;
  private final FileConfiguration config;

  private boolean teleportToSpawnOnJoin;
  private Location spawnLocation;

  private int maxBalance, minBalance, defaultBalance;

  private String currencySymbol, economyName, currencyNameSingular, currencyNamePlural;
  private boolean economyEnabled;

  public ApexConfigCache(ApexCore apexCore) {
    this.apexCore = apexCore;
    this.config = this.apexCore.getConfig();
    this.load();
  }

  private void load() {
    this.teleportToSpawnOnJoin = this.config.getBoolean("teleportOnJoin", false);
    if (this.config.isSet("spawn.location")) {
      this.spawnLocation = Utils.fromString(this.config.getString("spawn.location"));
    }

    if (this.config.isSet("economy.defaultBalance")) {
      this.defaultBalance = this.config.getInt("economy.defaultBalance");
    }

    this.maxBalance = this.config.getInt("economy.maxBalance", 10000000);

    this.minBalance = this.config.getInt("economy.minBalance", 0);

    this.currencySymbol = this.getConfig().getString("economy.currencySymbol", "$");

    this.economyEnabled = this.getConfig().getBoolean("economy.enabled", true);
    this.economyName = this.getConfig().getString("economy.name", "Apex");
    this.currencyNameSingular = this.getConfig().getString("economy.singularName", "Dollar");
    this.currencyNameSingular = this.getConfig().getString("economy.pluralName", "Dollars");
  }

  public FileConfiguration getConfig() {
    return this.config;
  }

  public Location getSpawnLocation() {
    return this.spawnLocation;
  }

  public void setSpawnLocation(Location spawnLocation) {
    this.spawnLocation = spawnLocation;
  }

  public boolean isSpawnSet() {
    return this.spawnLocation != null;
  }

  public boolean shouldTeleportToSpawnOnJoin() {
    return this.teleportToSpawnOnJoin;
  }

  public void setTeleportToSpawnOnJoin(boolean teleportToSpawnOnJoin) {
    this.teleportToSpawnOnJoin = teleportToSpawnOnJoin;
  }

  public int getDefaultBalance() {
    return this.defaultBalance;
  }

  public int getMinBalance() {
    return this.minBalance;
  }

  public int getMaxBalance() {
    return this.maxBalance;
  }

  public String getCurrencySymbol() {
    return currencySymbol;
  }

  public void setCurrencySymbol(String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }

  public boolean isEconomyEnabled() {
    return economyEnabled;
  }

  public String getEconomyName() {
    return economyName;
  }

  public String getCurrencyNamePlural() {
    return currencyNamePlural;
  }

  public String getCurrencyNameSingular() {
    return currencyNameSingular;
  }
}
