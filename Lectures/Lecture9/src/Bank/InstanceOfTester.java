package Bank;
public class InstanceOfTester{
  public static void main(String[] args){
   SuperSavingsAccount ss1 = new SuperSavingsAccount("Harold");
   PowerChequingAccount pc1 = new PowerChequingAccount("Kumar");

   BankAccount b1 = ss1;
   BankAccount b2 = pc1;
   BankAccount b3 = new PowerSavingsAccount("Maria"); //automatic conversion
   
   System.out.println("Is b1 a BankAccount? " + (b1 instanceof BankAccount)); //yes
   System.out.println("Is b1 a SavingsAccount? " + (b1 instanceof SavingsAccount)); //yes?
   System.out.println("Is b1 a SuperSavingsAccount? " + (b1 instanceof SuperSavingsAccount)); //yes?
   System.out.println("Is b1 a ChequingAccount? " + (b1 instanceof ChequingAccount)); //No
   
   System.out.println("Is b2 a BankAccount? " + (b2 instanceof BankAccount));//yes
   System.out.println("Is b2 a SavingsAccount? " + (b2 instanceof SavingsAccount)); //No
   System.out.println("Is b2 a SuperSavingsAccount? " + (b2 instanceof SuperSavingsAccount));//No
   System.out.println("Is b2 a ChequingAccount? " + (b2 instanceof ChequingAccount));//Yes?

   //Note the toString method is the same as the original class, not the type it is typecast too
   System.out.println(b1);
   System.out.println(b2);
   //b2.writeCheque(10);
   //pc1.writeCheque(10);
  }
}