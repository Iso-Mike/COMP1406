import java.net.*;
import java.io.*;
public class ObjectBankServer{
  public static final int DEPOSIT = 1;
  public static final int WITHDRAW = 2;
  public static final int BALANCE = 3;
  public static final int OPEN = 4;
  public static final int LIST = 5;
  public static final int SAVE = 6;
  public static final int LOAD = 7;
  
  
  public static int SERVER_PORT = 5000;
  
  public static void main(String[] args){
    Bank model = null;
    
    try{
      model = Bank.loadFrom(new BufferedReader(new FileReader("bank.txt")));
    }catch(Exception e){
      e.printStackTrace();
    }
    
    
    ServerSocket serverSocket = null;    
    try {
      serverSocket = new ServerSocket(SERVER_PORT);
      
    }
    catch(IOException e) {
      System.out.println("Cannot open server connection");
    } 
    
    Socket aClientSocket;
    try {
      while(true){
        aClientSocket = serverSocket.accept();
        
        
        ObjectOutputStream out = new ObjectOutputStream(aClientSocket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(aClientSocket.getInputStream());
        
        BankRequest req = (BankRequest)in.readObject();
        int operation = req.getRequestType();
        BankResponse res = new BankResponse();
        
        if(operation == DEPOSIT){
          int accountNum = Integer.parseInt(req.getParameter(BankRequest.ACCOUNTNUM));
          double amount = Double.parseDouble(req.getParameter(BankRequest.AMOUNT));
          boolean success = model.deposit(amount, accountNum);
          if(success){
            res.addParameter(BankResponse.MESSAGE, "Deposit successul");
          }else{
            res.addParameter(BankResponse.MESSAGE, "Deposit unsuccessul");
          }
        }else if(operation == WITHDRAW){
          int accountNum = Integer.parseInt(req.getParameter(BankRequest.ACCOUNTNUM));
          double amount = Double.parseDouble(req.getParameter(BankRequest.AMOUNT));
          boolean success = model.withdraw(amount, accountNum);
          if(success){
            res.addParameter(BankResponse.MESSAGE, "Withdraw successul");
          }else{
            res.addParameter(BankResponse.MESSAGE, "Withdraw unsuccessul");
          }
        }else if(operation == BALANCE){
          int accountNum = Integer.parseInt(req.getParameter(BankRequest.ACCOUNTNUM));
          double balance = model.checkBalance(accountNum);
          
          if(balance < 0){
            res.addParameter(BankResponse.MESSAGE, "Invalid account number.");
          }else{
            res.addParameter(BankResponse.MESSAGE, ""+balance);
          }
        }else if(operation == OPEN){
          String owner = req.getParameter(BankRequest.OWNERNAME);
          if(owner.length() > 0){
            model.addAccount(owner);
            res.addParameter(BankResponse.MESSAGE, "Account added successfuly.");
          }else{
            res.addParameter(BankResponse.MESSAGE, "Owner name must have at least one character.");
          }
        }
        
        out.writeObject(res);
      
        in.close();
        out.close();
        aClientSocket.close();
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    } catch(ClassNotFoundException e){
      System.out.println("Error loading class.");
    }
  }  
}