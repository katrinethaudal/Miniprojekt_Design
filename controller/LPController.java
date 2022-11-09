package controller;

import model.LPContainer;

public class LPController {
	private static LPController instance;
	
	private LPContainer lpContainer;
	
	public LPController() {
		lpContainer = LPContainer.getInstance();
	}
	
	public static LPController getInstance() {
		if (instance == null) {
			instance = new LPController();
		}
		return instance;
	}
	
	
}
