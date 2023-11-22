package com.cg;

public class BankAccount {
	private int amount=20000;

	public boolean withdraw(int amountToWithdraw) throws InsufficientFundsExpection{

	if(amount<amountToWithdraw) {

	throw new InsufficientFundsExpection();

	}
	else {

	amount-=amountToWithdraw;
	return true;
	}
}
}
