import java.net.*;
import java.io.*;
import java.util.*;
public class BankClient{
  public static int SERVER_PORT = 5000;
  public static final int DEPOSIT = 1;
  public static final int WITHDRAW = 2;
  public static final int BALANCE = 3;
  public static final int OPEN = 4;
  public static final int LIST = 5;
  public static final int SAVE = 6;
  public static final int LOAD = 7;
  
  public static void main(String[] args){
    
    try {      
      Scanner scan = new Scanner(System.in);
      System.out.println("Would you like to: deposit(1), withdraw(2), check balance(3), open account(4), list accounts(5), save(6), load(7)");
      int action = scan.nextInt();
      
      while(action >= 1 && action <= 7){
        InetAddress address = InetAddress.getLocalHost();
        Socket socket = new Socket(address, SERVER_PORT);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeInt(action);
        
        if(action == DEPOSIT){
          System.out.println("Enter account num: ");
          out.writeInt(scan.nextInt());
          System.out.println("Enter amount: ");
          out.writeDouble(scan.nextDouble());
          boolean success = in.readBoolean();
          
          if(success){
            System.out.println("Deposit successful");
          }else{
            System.out.println("Deposit unsuccessful");
          }
        }else if(action == WITHDRAW){
          System.out.println("Enter account num: ");
          out.writeInt(scan.nextInt());
          System.out.println("Enter amount: ");
          out.writeDouble(scan.nextDouble());
          boolean success = in.readBoolean();
          
          if(success){
            System.out.println("Withdraw successful");
          }else{
            System.out.println("Withdraw unsuccessful");
          }
        }else if(action == BALANCE){
          System.out.println("Enter account num: ");
          out.writeInt(scan.nextInt());
          double balance = in.readDouble();
          if(balance < 0){
            System.out.println("Account not found.");
          }else{
            System.out.println("The account balance was " + balance);
          }
        }else if(action == OPEN){
          System.out.println("Enter account owner name: ");
          String owner = scan.next();
          out.writeUTF(owner);
        }else if(action == LIST){
          System.out.println(in.readUTF());
        }else if(action == SAVE){
          System.out.println("Enter the file name: ");
          out.writeUTF(scan.next());
          boolean result = in.readBoolean();
          if(result){
            System.out.println("Saved succesfully.");
          }else{
            System.out.println("Error saving file.");
          }
        }else if(action == LOAD){
          System.out.println("Enter the file name: ");
          out.writeUTF(scan.next());
          boolean result = in.readBoolean();
          if(result){
            System.out.println("Loaded succesfully.");
          }else{
            System.out.println("Error loading file.");
          }
        }
        
        socket.close();
        in.close();
        out.close();
        
        System.out.println("Would you like to: deposit(1), withdraw(2), check balance(3), open account(4), list accounts(5), save(6), load(7)");
        action = scan.nextInt();
      }
      
      
    }
    catch(UnknownHostException e) {
      System.out.println("Host Unknown");
    }
    catch(IOException e) {
      System.out.println("Cannot connect to server");
    } 
  }
}