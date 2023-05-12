import java.util.*;
import java.io.*;
public class BankResponse implements Serializable{
  public static final byte MESSAGE = 1;
  private HashMap<Byte,String> parameters;
  
  public BankResponse(){
    parameters = new HashMap<Byte, String>();
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