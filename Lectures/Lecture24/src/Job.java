import java.io.*;
public class Job implements Serializable{
  private int length;
  private String name;
  private int jobNum;
  
  public Job(String iName, int iLength){
    length = iLength;
    name = iName;
  }
  
  public String getName(){
    return name;
  }
  
  public int getLength(){
    return length;
  }
  
  public String toString(){
    return name;
  }
}