package Insurance;

public interface Insurable{
  public int getPolicyNumber();
  public int getCoverageAmount();
  public double calculatePremium();
  public String getExpiryDate();
}