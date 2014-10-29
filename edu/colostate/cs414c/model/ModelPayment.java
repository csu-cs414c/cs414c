package Card;


public abstract class ModelPayment {
	protected float paymentAmount;
	protected float usergivenAmount;
	
	protected ModelPayment(float paymentAmount) {
		this.paymentAmount = paymentAmount;
	}	
	
	protected float getPaymentAmount() {
		return this.paymentAmount;
	}
	
	protected float calculcateChange() {
		return (this.usergivenAmount - this.paymentAmount);
	}	
	
}

