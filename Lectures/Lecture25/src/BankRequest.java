import java.util.*;
import java.io.*;
public class BankRequest implements Serializable{
  public static final byte DEPOSIT = 1;
  public static final byte WITHDRAW = 2;
  public static final byte BALANCE = 3;
  public static final byte OPEN = 4;
  public static final byte LIST = 5;
  public static final byte SAVE = 6;
  public static final byte LOAD = 7;
  public static final byte ACCOUNTNUM = 1;
  public static final byte AMOUNT = 2;
  public static final byte OWNERNAME = 3;
  
  
  
  private int requestType;
  private HashMap<Byte,String> parameters;
 
  public BankRequest(int type){
    requestType = type;
    parameters = new HashMap<Byte, String>();
  }
  
  public int getRequestType(){
    return requestType;
  }
 
  public void addParameter(Byte key, String value){
    parameters.put(key,value); 
  }
 
  public String getParameter(Byte key){
    if(parameters.containsKey(key)){
      return parameters.get(key);
    }
    return null;
  }
}