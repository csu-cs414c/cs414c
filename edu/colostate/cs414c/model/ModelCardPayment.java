package Card;

public class ModelCardPayment extends ModelPayment {

	
	protected String ccname;
	protected int ccexpiration;
	protected int cccode;
	
	protected ModelCardPayment(float paymentAmount) {
		super(paymentAmount);
	}
	
	public ModelCardPayment(float paymentAmount, String ccname, int ccexpiration, int cccode) {
		super(paymentAmount);
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
