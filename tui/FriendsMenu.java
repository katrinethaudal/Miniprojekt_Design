package tui;

import java.util.ArrayList;
import java.util.Scanner;

import controller.FriendController;
import model.Friend;

public class FriendsMenu {

	private FriendController friendController;
	
	public FriendsMenu() {
		friendController = new FriendController();
	}

	public void start() {
		friendsMenu();
	}

	private void friendsMenu() {
		boolean running = true;
		while (running) {
			int choice = writeFriendsMenu();
			switch (choice) {
			case 1:
				createFriend();
				break;
			case 2:
				findFriend();
				break;
			case 3:
				deleteFriend();
				break;
			case 4:
				updateFriend();
			case 0:
				running = false;
				break;
			default:
				System.out.println("En uforklarlig fejl er sket med choice = " + choice);
				break;
			}
		}
	}

	private void updateFriend() {
		System.out.println("Indtast navn: ");
		String name = getStringFromUser();
		Friend friend = friendController.findFriend(name);
		if (friend == null) {
			System.out.println("Ven ikke fundet!");
		}
		System.out.println("Indast ny adresse: (tom for ikke at ændre)");
		String address = getEmptyStringFromUser();
		System.out.println("Indast ny by (tom for ikke at ændre): ");
		String city = getEmptyStringFromUser();
		System.out.println("Indast nyt postnummer (tom for ikke at ændre): ");
		String postalcode = getEmptyStringFromUser();
		System.out.println("Indast ny email (tom for ikke at ændre): ");
		String email = getEmptyStringFromUser();
		System.out.println("Indast nyt telefonnummer (tom for ikke at ændre): ");
		String phoneNumber = getEmptyStringFromUser();
		friend = friendController.updateFriend(friend, address, city, postalcode, email, phoneNumber);
		System.out.println("LP opdateret");
		
	}

	private int writeFriendsMenu() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("****** Friends menu ******");
		System.out.println(" (1) Opret ven");
		System.out.println(" (2) Find ven");
		System.out.println(" (3) Slet ven");
		System.out.println(" (0) Tilbage");
		System.out.print("\n Vælg:");
		int choice = getIntegerFromUser(keyboard);
		return choice;
	}
	
	private void createFriend() {
		System.out.println("Indtast navn: ");
		String name = getStringFromUser();
		System.out.println("Indtast adresse: ");
		String address = getStringFromUser();
		System.out.println("Indtast by: ");
		String city = getStringFromUser();
		System.out.println("Indtast postnummer: ");
		String postalcode = getStringFromUser();
		System.out.println("Indtast email: ");
		String email = getStringFromUser();
		System.out.println("Indtast telefonnummer: ");
		String phonenumber = getStringFromUser();
		friendController.addFriend(name, address, city, postalcode, email, phonenumber);
		System.out.println("Ven oprettet");
	}
	
	private void deleteFriend() {
		System.out.println("Indtast navn: ");
		String name = getStringFromUser();
		friendController.deleteFriend(name);
		System.out.println("Ven slettet");
	}
	
	private void findFriend() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Indtast navn: ");
		String name = getStringFromUser();
		Friend friend = friendController.findFriend(name);
		if (friend != null) {
			System.out.println("Ven fundet: " + friend.getName());
			System.out.println("Adresse: " + friend.getAddress());
			System.out.println("By: " + friend.getCity());
			System.out.println("Postnummer: " + friend.getPostalCode());
			System.out.println("Email: " + friend.getEmail());
			System.out.println("Telefon: " + friend.getPhoneNumber());
		} else {
			System.out.println("Ven ikke fundet");
			ArrayList<Friend> friends = friendController.findAllFriends();
			System.out.println("Antal venner i system: " + friends.size());
		}
	}

	private int getIntegerFromUser(Scanner keyboard) {
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
	
	private String getEmptyStringFromUser() {
		Scanner keyboard = new Scanner(System.in);
		return keyboard.nextLine();
	}
}