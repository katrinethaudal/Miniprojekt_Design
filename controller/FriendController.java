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
    
    public void addFriend(String name, String address, String city, String postalcode, String email, String phonenumber) {
        Friend friend = new Friend(name);
        friend.setAddress(address);
        friend.setCity(city);
        friend.setEmail(email);
        friend.setPhoneNumber(phonenumber);
        friend.setPostalCode(postalcode);
        friendContainer.addFriend(friend);
    }
    
    public void deleteFriend(String name) {
        Friend friend = findFriend(name);
        if (friend == null) {
            return;
        }
        friendContainer.deleteFriend(friend);
    }
    
    /**
     * Remove the friend from the container and make it again with the new instance variables
     * @param friend
     * @param address
     * @param city
     * @param postalcode
     * @param email
     * @param phoneNumber
     * @return
     */
    public Friend updateFriend(Friend friend, String address, String city, String postalcode, String email,
            String phoneNumber) {
        friendContainer.deleteFriend(friend);
        if (!address.isEmpty()) {
            friend.setAddress(address);
        }
        if (!city.isEmpty()) {
            friend.setCity(city);
        }
        if (!postalcode.isEmpty()) {
            friend.setPostalCode(postalcode);
        }
        if (!email.isEmpty()) {
            friend.setEmail(email);
        }
        if (!phoneNumber.isEmpty()) {
            friend.setPhoneNumber(phoneNumber);
        }
        friendContainer.addFriend(friend);
        return friend;
    }
}
