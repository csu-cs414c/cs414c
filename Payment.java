
public abstract class Payment {
	protected float paymentAmount;
	protected float usergivenAmount;
	
	protected Payment(float paymentAmount, float usergivenAmount) {
		this.paymentAmount = paymentAmount;
		this.usergivenAmount = usergivenAmount;
	}	
	
	protected float getPaymentAmount() {
		return this.paymentAmount;
	}
	
	protected float getUserGivenAmount() {
		return this.usergivenAmount;
	}
	
	protected float calculcateChange() {
		return (this.usergivenAmount - this.paymentAmount);
	}	
	
}
