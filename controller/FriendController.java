package controller;

import java.util.ArrayList;

import model.Friend;
import model.FriendContainer;

public class FriendController {	
	private FriendContainer friendContainer;
	
	public FriendController() {
		friendContainer = FriendContainer.getInstance();
	}
	public Friend findFriend(String name) {
		return friendContainer.findFriend(name);
	}
	
	public ArrayList<Friend> findAllFriends() {
		return friendContainer.findAllFriends();
	}
	
	public void addFriend(String name) {
		Friend friend = new Friend(name);
		friendContainer.addFriend(friend);
	}
	
	public void deleteFriend(String name) {
		Friend friend = findFriend(name);
		if (friend == null) {
			return;
		}
		friendContainer.deleteFriend(friend);
	}
}
