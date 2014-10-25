
public class CreditPayment extends Payment{

	
	protected String ccname;
	protected int ccexpiration;
	protected int cccode;
	
	
	public CreditPayment(float paymentAmount, float usergivenAmount, String ccname, int ccexpiration, int cccode) {
		super(paymentAmount, usergivenAmount);
		this.ccname = ccname;
		this.ccexpiration = ccexpiration;
		this.cccode = cccode;
	}
	
	protected float calculateChange() {
		return super.calculcateChange();
	}
	
	protected float getPaymentAmount() {
		return super.getPaymentAmount();
	}
	
	protected float getUserGivenAmount() {
		return super.getUserGivenAmount();
	}
	
	public String getccname() {
		return this.ccname;
	}
	
	public int getccexpiration() {
		return this.ccexpiration;
	}
	
	public int getcccode() {
		return this.cccode;
	}
}
