package controller;

import model.Copy;
import model.Friend;
import model.LP;
import model.Loan;
import model.LoanContainer;

public class LoanController {	
	private LPController lpController;
	private FriendController friendController;
	private LoanContainer loanContainer;
	
	public LoanController() {
		lpController = new LPController();
		friendController = new FriendController();
		loanContainer = LoanContainer.getInstance();
	}
	
	
	public Loan createLoan(int loanNumber, int period, String friendName, int serialNumber, int copyNumber) {
		Friend friend = friendController.findFriend(friendName);
		if (friend == null) {
			System.out.println("Ven ikke fundet");
			return null;
		}
		LP lp = lpController.findLP(serialNumber);
		if (lp == null) {
			System.out.println("LP Ikke fundet");
			return null;
		}
		Copy copy = lp.getCopy(copyNumber);
		if (copy == null) {
			System.out.println("Copy er ikke fundet");
			return null;
		}
		Loan loan = new Loan(loanNumber, period, copy, serialNumber, friend);
		loanContainer.addLoan(loan);
		return loan;
	}


	public Loan findLoan(int loanNumber) {
		Loan loan = loanContainer.findLoan(loanNumber);
		return null;
	}
}
