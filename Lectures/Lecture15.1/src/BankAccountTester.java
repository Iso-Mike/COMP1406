public class BankAccountTester{
  public static void main(String[] args){
    try{
      BankAccount b1 = new BankAccount("Tywin");
      SavingsAccount s1 = new SavingsAccount("John");
      ChequingAccount c1 = new ChequingAccount("Tyrion");
      
      System.out.println("Checking deposit and withdraw methods");
      System.out.println(b1);
      b1.deposit(25.00);
      System.out.println(b1);
      b1.withdraw(5.00);
      System.out.println(b1);
      b1.withdraw(19.50);
      
      System.out.println(s1);
      s1.deposit(30.00);
      s1.deposit(15);
      System.out.println(s1);
      
      System.out.println(c1);
      c1.deposit(10);
      System.out.println(c1);
      c1.withdraw(5);
      System.out.println(c1);
      c1.deposit(25);
      System.out.println(c1);
      c1.writeCheque(15);
      System.out.println(c1);
      
      
      System.out.println("Checking the monthly upkeep methods.");
      System.out.println(b1);
      b1.monthlyUpkeep();
      System.out.println(b1);
      
      System.out.println(s1);
      s1.monthlyUpkeep();
      System.out.println(s1);
      
      System.out.println(c1);
      c1.monthlyUpkeep();
      System.out.println(c1);
    }catch(WithdrawException e){
      System.out.println(e.getMessage());
    }
    
    
  }
}