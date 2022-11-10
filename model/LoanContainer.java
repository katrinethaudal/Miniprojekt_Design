package model;

import java.util.ArrayList;

public class LoanContainer {
	private static LoanContainer instance;
	
	ArrayList<Loan> loans;
	private LoanContainer() {
		loans = new ArrayList<>();
	}
	
	public void addLoan(Loan loan) {
		loans.add(loan);
	}
	
	public static LoanContainer getInstance() {
		if (instance == null) {
			instance = new LoanContainer();
		}
		return instance;
	}

	public Loan findLoan(int loanNumber) {
		for (Loan loan : loans) {
			if (loan.getLoanNumber() == loanNumber) {
				return loan;
			}
		}
		return null;
	}
}
