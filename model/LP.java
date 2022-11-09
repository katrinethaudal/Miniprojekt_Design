package model;

import java.util.ArrayList;

public class LP {
	/**
	 * Serial number of the LP
	 */
	private int serialNumber;
	
	/**
	 * Title of the LP
	 */
	private String title;
	
	/**
	 * Artist of the LP
	 */
	private String artist;
	
	/**
	 * The publication date of the LP
	 */
	private String publicationDate;
	
	/**
	 * The available copies of the LP
	 */
	private ArrayList<Copy> copies;
	
	/**
	 * Constructor for the LP class
	 * @param serialNumber
	 * @param title
	 * @param artist
	 */
	public LP(int serialNumber, String title, String artist) {
		this.setSerialNumber(serialNumber);
		this.setTitle(title);
		this.setArtist(artist);
		copies = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public ArrayList<Copy> getCopies() {
		return copies;
	}
	
	/**
	 * Add a new copy of the LP
	 * @param copy
	 */
	public void addCopy(Copy copy) {
		copies.add(copy);
	}
	
}
