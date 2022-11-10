package controller;

import model.Copy;
import model.LP;
import model.LPContainer;

public class LPController {	
	private LPContainer lpContainer;
	
	public LPController() {
		lpContainer = LPContainer.getInstance();
	}
	
	public Copy findCopy(int serialNumber, int copyNumber) {
		return lpContainer.findCopy(serialNumber, copyNumber);
	}
	
	public LP findLP(int serialNumber) {
		return lpContainer.findLP(serialNumber);
	}
	
	public LP CreateLP(String name, int serialNumber, String artist, String publicationDate) {
		LP lp = new LP(serialNumber, name, artist);
		lp.setPublicationDate(publicationDate);
		lpContainer.AddLP(lp);
		return lp;
	}
	
	public Copy CreateCopy(int serialNumber, int copyNumber) {
		LP lp = lpContainer.findLP(serialNumber);
		if (lp == null) {
			System.out.println("LP findes ikke!");
		}
		Copy copy = new Copy(copyNumber, lp);
		lpContainer.AddCopy(serialNumber, copy);
		return copy;
	}

	public void deleteLP(int serialNumber) {
		LP lp = findLP(serialNumber);
		if (lp == null) {
			return;
		}
		lpContainer.deleteLP(lp);
	}

	public LP updateLP(LP lp, String newTitle, String newArtist, String newPublicationDate) {
		lpContainer.deleteLP(lp);
		if (!newTitle.isEmpty()) {
			lp.setTitle(newTitle);
		}
		if (!newArtist.isEmpty()) {
			lp.setArtist(newArtist);
		}
		if (!newPublicationDate.isEmpty()) {
			lp.setPublicationDate(newPublicationDate);
		}
		lpContainer.AddLP(lp);
		return lp;
	}

	public void deleteCopy(int serialNumber, int copyNumber) {
		lpContainer.deleteCopy(serialNumber, copyNumber);
		
	}

}
