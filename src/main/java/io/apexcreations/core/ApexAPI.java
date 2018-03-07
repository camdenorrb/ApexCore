package io.apexcreations.core;

import io.apexcreations.core.api.database.DatabaseAdapter;
import io.apexcreations.core.api.modules.Module;
import java.util.UUID;
import me.savvy.api.cache.ApexMapCache;
import me.savvy.api.cache.ApexSetCache;
import me.savvy.api.database.DatabaseAdapter;
import me.savvy.api.modules.Module;
import me.savvy.api.players.ApexPlayer;
import me.savvy.main.cache.ApexConfigCache;
import me.savvy.main.cache.ApexModuleCache;
import me.savvy.main.cache.ApexPlayerCache;
import me.savvy.main.cache.SubCommandCache;

public class ApexAPI {

  private final ApexCore apexCore;
  private final ApexMapCache<UUID, ApexPlayer> apexPlayerCache;
  private final ApexSetCache<Module> apexModuleCache;
 //private final ApexPlayerCache apexPlayerCache;
  private final SubCommandCache subCommandCache;
 // private final ApexModuleCache apexModuleCache;
  private final ApexConfigCache apexConfigCache;
  private DatabaseAdapter databaseAdapter;

  public ApexAPI() {
    this.apexCore = ApexCore.getInstance();
 //   this.apexPlayerCache = new ApexPlayerCache();
   // this.apexModuleCache = new ApexModuleCache();
    this.subCommandCache = new SubCommandCache();
    this.apexConfigCache = new ApexConfigCache(this.apexCore);
    this.apexPlayerCache = new ApexMapCache<>();
    this.apexModuleCache = new ApexSetCache<>();
    this.handleDatabase();
  }

  public ApexMapCache<UUID, ApexPlayer> getPlayerCache() {
    return this.apexPlayerCache;
  }

  public SubCommandCache getSubCommandCache() {
    return this.subCommandCache;
  }

  public ApexSetCache<Module> getApexModuleCache() {
    return this.apexModuleCache;
  }

  public DatabaseAdapter getDatabaseAdapter() {
    return databaseAdapter;
  }

  public ApexConfigCache getApexConfigCache() {
    return this.apexConfigCache;
  }

  private void handleDatabase() {
    if (!this.apexCore.getConfig().getBoolean("mysql.enabled")) {
      return;
    }
    this.databaseAdapter = new DatabaseAdapter(
        this.apexCore.getConfig().getString("mysql.hostName"),
        this.apexCore.getConfig().getInt("mysql.port"),
        this.apexCore.getConfig().getString("mysql.userName"),
        this.apexCore.getConfig().getString("mysql.password"),
        this.apexCore.getConfig().getString("mysql.databaseName"));
  }
}