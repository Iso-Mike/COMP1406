package Insurance;

public interface DepreciatingInsurable extends Insurable{
  public double computeFairMarketValue();
  public void amortizePayments();
}