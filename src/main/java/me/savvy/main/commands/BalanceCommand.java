package me.savvy.main.commands;

import me.savvy.api.commands.ApexCommand;
import org.bukkit.command.CommandSender;

public class BalanceCommand extends ApexCommand {

  public BalanceCommand(String name, String description, String permission, boolean playerOnly,
      String... aliases) {
    super(name, description, permission, playerOnly, aliases);
  }

  @Override
  public boolean executeCommand(CommandSender commandSender, String label, String[] args) {
    return false;
  }
}
