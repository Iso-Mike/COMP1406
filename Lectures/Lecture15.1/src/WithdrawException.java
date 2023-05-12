public class WithdrawException extends Exception{
  static final int INSUFFICIENT_FUNDS = 0;
  static final int NETWORK_COMMUNICATION_ERROR = 1;

  public WithdrawException(String s){
    super(s);
  }
}