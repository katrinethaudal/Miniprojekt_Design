package controller;

import model.Friend;
import model.Loan;
import model.LoanContainer;

public class LoanController {
	private static LoanController instance;
	
	private LPController lpController;
	private FriendController friendController;
	private LoanContainer loanContainer;
	
	public LoanController() {
		lpController = LPController.getInstance();
	}
	
	
	public Loan createLoan(String friendName, int copyNumber) {
		Friend friend = friendController.findFriend(friendName);
		
		// ikke færdig
		return null;
	}
}
