import java.net.*;
import java.io.*;
public class BankServer{
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
        
        DataInputStream in = new DataInputStream(aClientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(aClientSocket.getOutputStream());
        
        
        //Start new code - determining the operation, reading the proper information
        //Handling the request and sending a response
        int operation = in.readInt();
        
        if(operation == DEPOSIT){
          int accountNum = in.readInt();
          double amount = in.readDouble();
          boolean success = model.deposit(amount, accountNum);
          out.writeBoolean(success);
        }else if(operation == WITHDRAW){
           int accountNum = in.readInt();
           double amount = in.readDouble();
           boolean success = model.withdraw(amount, accountNum);
           out.writeBoolean(success);
        }else if(operation == BALANCE){
           int accountNum = in.readInt();
           double balance = model.checkBalance(accountNum);
           out.writeDouble(balance);
        }else if(operation == OPEN){
          String owner = in.readUTF();
          if(owner.length() > 0){
            model.addAccount(owner);
          }
        }else if(operation == LIST){
          out.writeUTF(model.list());
        }else if(operation == SAVE){
          String file = in.readUTF();
          out.writeBoolean(model.save(file));
        }else if(operation == LOAD){
          String file = in.readUTF();
          Bank b = model.load(file);
          if(b != null){
            model = b;
            out.writeBoolean(true);
          }else{
            out.writeBoolean(false);
          }
        }
      
        //End new code
        in.close();
        out.close();
        aClientSocket.close();
      }
    }
    catch(IOException e) {
      System.out.println("Cannot connect to client");
    }  
  }  
}