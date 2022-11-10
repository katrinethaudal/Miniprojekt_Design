package controller;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Friend;

/**
 * The test class FriendControllerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FriendControllerTest
{
    FriendController friendController;
    /**
     * Default constructor for test class FriendControllerTest
     */
    public FriendControllerTest()
    {
        friendController = new FriendController();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void TestCreateFriend() {
        String name = "name";
        String address = "testadr";
        String city = "testcity";
        String postalCode = "postalCode";
        String email = "email";
        String phone = "phone";
        friendController.addFriend(name, address, city, postalCode, email, phone);
        
        Friend friend = friendController.findFriend(name);
        assertNotNull(friend);    
        assertEquals(name, friend.getName());
        assertEquals(address, friend.getAddress());
        assertEquals(city, friend.getCity());
        assertEquals(postalCode, friend.getPostalCode());
        assertEquals(email, friend.getEmail());
        assertEquals(phone, friend.getPhoneNumber());
    }
    
    @Test
    public void TestDeleteFriend() {
        String name = "name2";
        String address = "testadr";
        String city = "testcity";
        String postalCode = "postalCode";
        String email = "email";
        String phone = "phone";
        friendController.addFriend(name, address, city, postalCode, email, phone);
        
        Friend friend = friendController.findFriend(name);
        assertNotNull(friend); 
    
        friendController.deleteFriend(name);
        Friend deletedFriend = friendController.findFriend(name);
        assertNull(deletedFriend); 
    }
    
    @Test
    public void TestUpdateFriend() {
        String name = "name3";
        String address = "testadr";
        String city = "testcity";
        String postalCode = "postalCode";
        String email = "email";
        String phone = "phone";
        friendController.addFriend(name, address, city, postalCode, email, phone);
        
        Friend friend = friendController.findFriend(name);
        assertNotNull(friend);    
        assertEquals(name, friend.getName());
        assertEquals(address, friend.getAddress());
        assertEquals(city, friend.getCity());
        assertEquals(postalCode, friend.getPostalCode());
        assertEquals(email, friend.getEmail());
        assertEquals(phone, friend.getPhoneNumber());
        
        String newAddress = "adress 2";
        String newPhone = "new phone";
        friendController.updateFriend(friend, newAddress, "", "", "", newPhone);
        
        friend = friendController.findFriend(name);
        assertNotNull(friend);    
        assertEquals(name, friend.getName());
        assertEquals(newAddress, friend.getAddress());
        assertEquals(city, friend.getCity());
        assertEquals(postalCode, friend.getPostalCode());
        assertEquals(email, friend.getEmail());
        assertEquals(newPhone, friend.getPhoneNumber());
    }
}
