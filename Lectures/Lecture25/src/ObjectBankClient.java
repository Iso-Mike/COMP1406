import java.net.*;
import java.io.*;
import java.util.*;
public class ObjectBankClient{
  public static int SERVER_PORT = 5000;
  public static final int DEPOSIT = 1;
  public static final int WITHDRAW = 2;
  public static final int BALANCE = 3;
  public static final int OPEN = 4;
  public static final int LIST = 5;
  public static final int SAVE = 6;
  public static final int LOAD = 7;
  private static Scanner scan = new Scanner(System.in);
  
  public static void main(String[] args){
    
    try {      
      
      System.out.println("Would you like to: deposit(1), withdraw(2), check balance(3), open account(4)");
      int action = scan.nextInt();
      
      while(action >= BankRequest.DEPOSIT && action <= BankRequest.OPEN){
       
        BankRequest req = null;
        if(action == DEPOSIT){
          req = buildDepositRequest();
        }else if(action == WITHDRAW){
          req = buildWithdrawRequest();
        }else if(action == BALANCE){
          req = buildBalanceRequest();
        }else if(action == OPEN){
         req = buildOpenRequest();
        }else{
          System.out.println("Invalid request");
        }
          
        if(req != null){        
          InetAddress address = InetAddress.getLocalHost();
          Socket socket = new Socket(address, SERVER_PORT);
          
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
          
          out.writeObject(req);
          BankResponse res = (BankResponse)in.readObject();
          System.out.println(res.getParameter(BankResponse.MESSAGE));
          
          socket.close();
          in.close();
          out.close();
        }
        
        System.out.println("Would you like to: deposit(1), withdraw(2), check balance(3), open account(4)");
        action = scan.nextInt();
      }
      
      
    }catch(ClassNotFoundException e){
      System.out.println("Class not found");
    }
    catch(UnknownHostException e) {
      System.out.println("Host Unknown");
    }
    catch(IOException e) {
      System.out.println("Cannot connect to server");
    } 
  }
  
  public static BankRequest buildDepositRequest(){
    BankRequest req = new BankRequest(BankRequest.DEPOSIT);
    System.out.println("Enter account num: ");
    req.addParameter(BankRequest.ACCOUNTNUM, scan.next());
    System.out.println("Enter amount: ");
    req.addParameter(BankRequest.AMOUNT, scan.next()); 
    return req;
  }
  
  public static BankRequest buildWithdrawRequest(){
    BankRequest req = new BankRequest(BankRequest.WITHDRAW);
    System.out.println("Enter account num: ");
    req.addParameter(BankRequest.ACCOUNTNUM, scan.next());
    System.out.println("Enter amount: ");
    req.addParameter(BankRequest.AMOUNT, scan.next()); 
    return req;
  }
  
  public static BankRequest buildBalanceRequest(){
    BankRequest req = new BankRequest(BankRequest.BALANCE);
    System.out.println("Enter account num: ");
    req.addParameter(BankRequest.ACCOUNTNUM, scan.next());
    return req;
  }
  
  public static BankRequest buildOpenRequest(){
    BankRequest req = new BankRequest(BankRequest.OPEN);
    System.out.println("Enter account owner name: ");
    req.addParameter(BankRequest.OWNERNAME, scan.next());
    return req;
  }
}