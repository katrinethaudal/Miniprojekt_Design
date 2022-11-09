package model;

public class Copy {
	private int copyNumber;
	private int lpSerialNumber;

	public Copy(int copyNumber, int lpSerialNumber) {
		this.copyNumber = copyNumber;
		this.lpSerialNumber = lpSerialNumber;
	}
	
	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public int getLpSerialNumber() {
		return lpSerialNumber;
	}

	public void setLpSerialNumber(int lpSerialNumber) {
		this.lpSerialNumber = lpSerialNumber;
	}

}
