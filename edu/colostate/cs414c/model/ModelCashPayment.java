package Card;

public class ModelCashPayment extends ModelPayment{
	protected float paymentAmount;
	protected float cashrendered;
	
	protected ModelCashPayment(float paymentAmount) {
		super(paymentAmount);
	}
	
	protected void setCashRendered(float cashrendered) {
		this.cashrendered = cashrendered;
	}
	
	protected float getPaymentAmount() {
		return this.paymentAmount;
	}
	
	protected float getUserGivenAmount() {
		return this.cashrendered;
	}
	
	protected float calculcateChange() {
		return (this.cashrendered - this.paymentAmount);
	}	

}
