package tui;

import java.util.Scanner;

import controller.LoanController;
import model.Loan;

public class LoanMenu {

	private LoanController loanController;
	
	public LoanMenu() {
		loanController = new LoanController();
	}

	public void start() {
		loanMenu();
	}

	private void loanMenu() {
		boolean running = true;
		while (running) {
			int choice = writeLoanMenu();
			switch (choice) {
			case 1:
				createLoan();
				break;
			case 2:
				getLoan();
			case 0:
				running = false;
				break;
			default:
				System.out.println("En uforklarlig fejl er sket med choice = " + choice);
				break;
			}
		}
	}

	private int writeLoanMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("****** Udlånsmenu ******");
		System.out.println(" (1) Opret lån");
		System.out.println(" (2) Find lån");
		System.out.println(" (0) Tilbage");
		System.out.print("\n Vælg:");
		int choice = getIntegerFromUser();
		return choice;
	}
	
	private void createLoan() {
		System.out.println("Indtast lånenummer: ");
		int loanNumber = getIntegerFromUser();
		System.out.println("Indtast lånets længde i dage: ");
		int period = getIntegerFromUser();
		System.out.println("Indtast navn på ven: ");
		String name = getStringFromUser();
		System.out.println("Indtast LP serienummer: ");
		int serialNumber = getIntegerFromUser();
		System.out.println("Indtast kopinummer: ");
		int copyNumber = getIntegerFromUser();
		Loan loan = loanController.createLoan(loanNumber, period, name, serialNumber, copyNumber);
		if (loan == null) {
			System.out.println("Lån er ikke oprettet");
		} else {
			System.out.println("Lån oprettet med nummer: " + loan.getLoanNumber());
		}
	}
	
	private void getLoan() {
		System.out.println("Indtast lånenummer: ");
		int loanNumber = getIntegerFromUser();
		Loan loan = loanController.findLoan(loanNumber);
		if (loan == null) {
			System.out.println("Lån ikke fundet!");
		} else {
			System.out.println("Lån fundet med nummer: " + loan.getLoanNumber());
			System.out.println("Lånets periode: " + loan.getPeriod());
			System.out.println("Kopi: " + loan.getCopy().getCopyNumber());
			System.out.println("Lånets status: " + loan.getState());
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
