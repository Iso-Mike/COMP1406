/*
State: owner, account #, institution, balance, fee
Behaviour: deposit, withdraw, check balance
*/
public class BankAccount {

  protected Person owner;
  protected Bank institution;
  protected double balance;
  protected double monthlyFee;
  protected int accountNumber;
  protected static int nextAccountNumber = 10000;

  public BankAccount(Person owner, Bank inst){
    this.owner = owner;
    this.institution = inst;
    balance = 0.0;
    monthlyFee = 5.0;
    accountNumber = nextAccountNumber;
    nextAccountNumber++;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public double getBalance() {
    return balance;
  }

  public Person getOwner() {
    return owner;
  }

  public double getMonthlyFee() {
    return monthlyFee;
  }

  public void setAccountNumber(int accountNumber) {
    this.accountNumber = accountNumber;
  }

  protected void setBalance(double balance) {
    this.balance = balance;
  }

  public void monthlyUpkeep(){
    if(balance >= monthlyFee){
      balance -= monthlyFee;
    }
  }

  public boolean deposit(double amount){
    if(amount > 0) {
      balance += amount;
      return true;
    }
    return false;
  }

  public boolean withdraw(double amount){
    if(amount <= balance){
      balance -= amount;
      return true;
    }
    return false;
  }

  public double checkBalance(){
    return balance;
  }

  public String toString(){
    return owner + "'s bank account with $" + balance + " (Account #" + accountNumber + ")";
  }
}