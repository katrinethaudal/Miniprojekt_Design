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
	
	public Copy findCopy(int copyNumber) {
		for (LP lp : lps) {
			ArrayList<Copy> copies = lp.getCopies();
			for (Copy copy : copies) {
				if (copy.getCopyNumber() == copyNumber) {
					return copy;
				}
			}
		}
		return null;
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
	
}
