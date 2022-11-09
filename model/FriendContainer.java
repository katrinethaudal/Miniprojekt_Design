package model;

import java.util.ArrayList;

public class FriendContainer {
	public static FriendContainer instance;
	
	private ArrayList<Friend> friends;
	
	private FriendContainer() {
		friends = new ArrayList<>();
	}
	
	public static FriendContainer getInstance() {
		if (instance == null) {
			instance = new FriendContainer();
		}
		return instance;
	}
	
	public Friend findFriend(String name) {
		for (Friend friend : friends) {
			if (friend.getName() == name) {
				return friend;
			}
		}
		return null;
	}
}
