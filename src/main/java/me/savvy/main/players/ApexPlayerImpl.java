package me.savvy.main.players;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import me.savvy.api.players.ApexPlayer;
import me.savvy.main.account.Account;
import org.bukkit.Location;

public class ApexPlayerImpl implements ApexPlayer {

  private final UUID uniqueId;
  private final Account account;
  private final Map<String, Location> homes;

  public ApexPlayerImpl(UUID uuid) {
    this.uniqueId = uuid;
    this.account = new Account(this.uniqueId);
    this.homes = new HashMap<>();
  }

  @Override
  public Account getAccount() {
    return this.account;
  }

  @Override
  public Map<String, Location> getHomes() {
    return Collections.unmodifiableMap(this.homes);
  }

  @Override
  public UUID getUniqueId() {
    return this.uniqueId;
  }
}
