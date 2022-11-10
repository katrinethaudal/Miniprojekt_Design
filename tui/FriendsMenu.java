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
			case 0:
				running = false;
				break;
			default:
				System.out.println("En uforklarlig fejl er sket med choice = " + choice);
				break;
			}
		}
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
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Indtast navn: ");
		String name = getStringFromUser(keyboard);
		friendController.addFriend(name);
		System.out.println("Ven oprettet");
	}
	
	private void deleteFriend() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Indtast navn: ");
		String name = getStringFromUser(keyboard);
		friendController.deleteFriend(name);
		System.out.println("Ven slettet");
	}
	
	private void findFriend() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Indtast navn: ");
		String name = getStringFromUser(keyboard);
		Friend friend = friendController.findFriend(name);
		if (friend != null) {
			System.out.println("Ven fundet: " + friend.getName());
		} else {
			System.out.println("Ven ikke fundet");
			ArrayList<Friend> friends = friendController.findAllFriends();
			System.out.println("Antal venner: " + friends.size());
		}
	}

	private int getIntegerFromUser(Scanner keyboard) {
		while (!keyboard.hasNextInt()) {
			System.out.println("Input skal være et tal - prøv igen");
			keyboard.nextLine();
		}
		return keyboard.nextInt();
	}
	
	private String getStringFromUser(Scanner keyboard) {
		while (!keyboard.hasNextLine()) {
			System.out.println("Der skal indtastest et navn");
			keyboard.nextLine();
		}
		return keyboard.nextLine();
	}
}