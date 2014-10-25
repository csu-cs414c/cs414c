
public class CashPayment extends Payment{

	protected CashPayment(float paymentAmount, float usergivenAmount) {
		super(paymentAmount, usergivenAmount);
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

}
