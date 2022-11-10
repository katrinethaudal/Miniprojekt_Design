package model;

import java.util.ArrayList;

public class LPContainer {
	private ArrayList<LP> lps;
	
	private static LPContainer instance; 
	
	private LPContainer() {
		lps = new ArrayList<>();
	}
	
	/**
	 * Add a LP to the container
	 * @param lp
	 */
	public void AddLP(LP lp) {
		lps.add(lp);
	}
	
	public void AddCopy(int lpSerialNumber, Copy copy) {
		LP lp = findLP(lpSerialNumber);
		if (lp == null) {
			return;
		}
		lp.addCopy(copy);
	}
	
	public Copy findCopy(int serialNumber, int copyNumber) {
		LP lp = findLP(serialNumber);
		if (lp == null) {
			return null;
		}
		return lp.getCopy(copyNumber);
	}
	
	public LP findLP(int serialNumber) {
		for (LP lp : lps) {
			if (lp.getSerialNumber() == serialNumber) {
				return lp;
			}
		}
		return null;
	}
	
	public static LPContainer getInstance() {
		if (instance == null) {
			instance =  new LPContainer();
		}
		return instance;
	}

	public void deleteLP(LP lp) {
		lps.remove(lp);
	}

	public void deleteCopy(int serialNumber, int copyNumber) {
		for (LP lp : lps) {
			if (lp.getSerialNumber() == serialNumber) {
				lp.deleteCopy(copyNumber);
			}
		}
		
	}
}
