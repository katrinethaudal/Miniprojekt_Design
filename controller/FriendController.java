package controller;

import model.Friend;
import model.FriendContainer;

public class FriendController {
	private static FriendController instance;
	
	private FriendContainer friendContainer;
	
	private FriendController() {
		
	}
	public Friend findFriend(String name) {
		return friendContainer.findFriend(name);
	}
	
	public static FriendController getInstance() {
		if (instance == null) {
			instance = new FriendController();
		}
		return instance;
	}
}
