package io.apexcreations.core.main.account;

import java.math.BigDecimal;
import java.util.UUID;
import me.savvy.ApexAPI;
import me.savvy.ApexCore;
import me.savvy.api.exceptions.MaxMoneyException;

public class Account {

  private final UUID accountOwner;
  private ApexAPI api;
  private BigDecimal balance;

  public Account(UUID accountOwner) {
    this.accountOwner = accountOwner;
    this.api = ApexCore.getInstance().getApexAPI();
    this.load();
  }

  private void load() {
    this.balance = BigDecimal.ZERO;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setBalance(BigDecimal balance) throws MaxMoneyException {
    if ((balance.doubleValue() + this.balance.doubleValue()) >
        api.getApexConfigCache().getMaxBalance() ||
        (balance.doubleValue() - this.balance.doubleValue()) <
            api.getApexConfigCache().getMinBalance()) {
      throw new MaxMoneyException();
    }
    this.balance = balance;
  }

  public void addToBalance(double amount) throws MaxMoneyException {
    this.setBalance(this.balance.add(this.toBigDecimal(amount)));
  }

  public void removeFromBalance(double amount) throws MaxMoneyException {
    this.setBalance(this.balance.subtract(this.toBigDecimal(amount)));
  }

  public UUID getAccountOwner() {
    return this.accountOwner;
  }

  private BigDecimal toBigDecimal(double amount) {
    return BigDecimal.valueOf(amount);
  }
}