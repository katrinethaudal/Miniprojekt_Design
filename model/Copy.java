package model;

public class Copy {
	private int copyNumber;
	private LP lp;

	public Copy(int copyNumber, LP lp) {
		this.copyNumber = copyNumber;
		this.lp = lp;
	}
	
	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public LP getLP() {
		return lp;
	}

	public void setLP(LP lp) {
		this.lp = lp;
	}

}
