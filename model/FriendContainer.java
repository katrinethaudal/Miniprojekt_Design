package model;

import java.util.ArrayList;

public class FriendContainer {
    public static FriendContainer instance;
    
    private ArrayList<Friend> friends;
    
    private FriendContainer() {
        friends = new ArrayList<>();
    }
    
    public void addFriend(Friend friend) {
        friends.add(friend);
    }
    
    public Friend findFriend(String name) {
        for (Friend friend : friends) {
            if (friend.getName().equals(name)) {
                return friend;
            }
        }
        return null;
    }
    
    public ArrayList<Friend> findAllFriends() {
        return friends;
    }


    public void deleteFriend(Friend friend) {
        friends.remove(friend);
    }
    
    public static FriendContainer getInstance() {
        if (instance == null) {
            instance = new FriendContainer();
        }
        return instance;
    }
}
