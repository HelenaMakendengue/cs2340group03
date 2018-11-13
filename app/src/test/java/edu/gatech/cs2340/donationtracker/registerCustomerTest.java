package edu.gatech.cs2340.donationtracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the registerCustomer method in Model
 * Method is suppose to check the information entered, then add a new user to the database
 * Created by Alexa Flesch on 11/11/2019.
 */
@SuppressWarnings("JavaDoc")
public class registerCustomerTest {

    private Model testModel;

    @Before
    public void setUp() {
        testModel = new Model();
    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void validItem() {
        assertEquals("Zuko added to database",
                "Customer created successfully.", testModel.registerCustomer("Zuko",
                        "Imustrestoremyhonor", "princeZuko@gmail.com"));

    }
    @SuppressWarnings("JavaDoc")
    @Test
    public void invalidEmail() {
        assertEquals("Invalid email",
                "The email you entered is not a email.", testModel.registerCustomer(
                        "Toff", "twinkeToes", "iCantSee"));
    }

    @Test
    public void passwordTooShort() {
        assertEquals("Katara's password too short",
                "Password too short.", testModel.registerCustomer("Katara",
                        "nope", "itsKatara@gmail.com"));
    }

    @Test
    public void stopDuplicates() {
        testModel.registerCustomer("Zuko", "Imustrestoremyhonor",
                "princeZuko@gmail.com");
        assertEquals("Zuko not duplicated",
                "Username already taken", testModel.registerCustomer("Zuko",
                        "Imustrestoremyhonor", "princeZuko@gmail.com"));
    }
    @Test
    public void usernameNotEmpty() {
        assertEquals("Checks username not empty",
                "One or more empty field(s)", testModel.registerCustomer("",
                        "Imustrestoremyhonor", "princeZuko@gmail.com"));
    }
    @Test
    public void passwordNotEmpty() {
        assertEquals("Checks password not empty",
                "One or more empty field(s)", testModel.registerCustomer("Aang",
                        "", "princeZuko@gmail.com"));
    }
    @Test
    public void emailNotEmpty() {
        assertEquals("Checks password not empty",
                "One or more empty field(s)", testModel.registerCustomer("Sokka",
                        "myGirlfriendIsTheMoon", ""));
    }
}