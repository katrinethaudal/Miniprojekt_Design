package model;

public class Loan {
	private int loanNumber;
	private String loanDate;
	private int period;
	private String state;
	private Copy copy;
	private Friend friend;
	
	public Loan(int loanNumber, int period, Copy copy, Friend friend) {
		this.loanNumber = loanNumber;
		this.copy = copy;
		this.friend = friend;
		this.period = period;
	}

	public int getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}

	public Copy getCopy() {
		return copy;
	}

	public void setCopy(Copy copy) {
		this.copy = copy;
	}

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
