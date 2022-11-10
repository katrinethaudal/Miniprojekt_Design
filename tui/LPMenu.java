package tui;

import java.util.Scanner;

import controller.LPController;
import model.Copy;
import model.LP;

public class LPMenu {
	LPController lpController;
	public LPMenu() {
		lpController = new LPController();
	}

	public void start() {
		lpMenu();
	}

	private void lpMenu() {
		boolean running = true;
		while (running) {
			int choice = writeLPMenu();
			switch (choice) {
			case 1:
				createLP();
				break;
			case 2:
				createCopy();
				break;
			case 3:
				findLP();
				break;
			case 4:
				findCopy();
				break;
			case 5:
				System.out.println("Ikke implementeret endnu!");
				break;
			case 6:
				deleteLP();
				break;
			case 7:
				System.out.println("Ikke implementeret endnu!");
				break;
			case 0:
				running = false;
				break;
			default:
				System.out.println("En uforklarlig fejl er sket med choice = " + choice);
				break;
			}
		}
	}

	private void deleteLP() {
		System.out.println("Indtast LP serienummer: ");
		int serialNumber = getIntegerFromUser();
		lpController.deleteLP(serialNumber);
	}

	private void findCopy() {
		System.out.println("Indtast LP serienummer: ");
		int serialNumber = getIntegerFromUser();
		System.out.println("Indtast kopinummer: ");
		int copyNumber = getIntegerFromUser();
		Copy copy = lpController.findCopy(serialNumber, copyNumber);
		if (copy == null) {
			System.out.println("Kopi ikke fundet");
		} else {
			System.out.println("Kopi fundet: " + copy.getCopyNumber());
		}
	}

	private void findLP() {
		System.out.println("Indtast LP serienummer: ");
		int serialNumber = getIntegerFromUser();
		LP lp = lpController.findLP(serialNumber);
		if (lp == null) {
			System.out.println("LP Ikke fundet");
		} else {
			System.out.println("LP fundet: " + lp.getSerialNumber());
			System.out.println("Titel: " + lp.getTitle());
			System.out.println("Kunstner: " + lp.getArtist());
		}
	}

	private int writeLPMenu() {
		System.out.println("****** LP menu ******");
		System.out.println(" (1) Opret LP");
		System.out.println(" (2) Opret Kopi");
		System.out.println(" (3) Find LP");
		System.out.println(" (4) Find Kopi");
		System.out.println(" (5) Rediger LP");
		System.out.println(" (6) Slet LP");
		System.out.println(" (7) Slet Kopi");
		System.out.println(" (0) Tilbage");
		System.out.print("\n Vælg:");
		int choice = getIntegerFromUser();
		return choice;
	}
	
	private void createLP() {
		System.out.println("Indtast LP serienummer: ");
		int serialNumber = getIntegerFromUser();
		System.out.println("Indtast navn på LP: ");
		String name = getStringFromUser();
		System.out.println("Indtast navn på kunstner: ");
		String artist = getStringFromUser();
		LP lp = lpController.CreateLP(name, serialNumber, artist);
		if (lp == null) {
			System.out.println("LP Ikke oprettet");
		} else {
			System.out.println("LP Oprettet korrekt");
		}
	}
	
	private void createCopy() {
		System.out.println("Indtast LP serienummer: ");
		int serialNumber = getIntegerFromUser();
		System.out.println("Indtast kopinummer: ");
		int copyNumber = getIntegerFromUser();
		Copy copy = lpController.CreateCopy(serialNumber, copyNumber);
		if (copy == null) {
			System.out.println("Copy Ikke oprettet");
		} else {
			System.out.println("Copy Oprettet korrekt");
		}
	}

	private int getIntegerFromUser() {
		Scanner keyboard = new Scanner(System.in);
		while (!keyboard.hasNextInt()) {
			System.out.println("Input skal være et tal - prøv igen");
			keyboard.nextLine();
		}
		return keyboard.nextInt();
	}
	
	private String getStringFromUser() {
		Scanner keyboard = new Scanner(System.in);
		while (!keyboard.hasNextLine()) {
			System.out.println("Der skal indtastest et navn");
			keyboard.nextLine();
		}
		return keyboard.nextLine();
	}
}