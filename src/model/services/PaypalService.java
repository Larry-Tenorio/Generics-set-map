package model.services;

public class PaypalService implements OnlinePaymentService{
	
	private static final double INTEREST_RATE = 0.01;
	private static final double PAYMENT_FEE = 0.02;

	@Override
	public double paymentFee(Double amount) {
		return amount * PAYMENT_FEE;
	}
	
	@Override
	public double interest(Double amount, Integer months) {
		return amount * INTEREST_RATE * months;
	}

	
}
