/**
 *  Title      : logintest.java
 *  Description: A TDD to test the login function of our engineering
 *
 *  @author  Yuanchi Zhou
 *  @version 1.0
 */

package test;

import control.LoginControl;
import org.junit.Test;

import static org.junit.Assert.*;


public class logintest {

    @Test
    public void testID(){
        // Test if the CheckID method correctly reads the ID for the correct student
        LoginControl loginControl = new LoginControl();
        String situation1 = "jp2020213333";//the correct ID but not the suitable ID
        String situation2 = "jp2020213326";//the correct and suitable ID
        String situation3 = "jp2123213213";//the ID which doesn't exist in date
        String expected = loginControl.checkID("jp2020213326", "123123");
        assertNotEquals(expected, situation1);//scan the wrong ID should not log in
        assertEquals(expected, situation2);//scan the ID should be able to log in
        assertNotEquals(expected, situation3);//scan the wrong ID should not log in
    }

    @Test
    public void testpassword(){
        // Test if the CheckID method correctly reads the password for the suitable student
        LoginControl loginControl = new LoginControl();
        String situation1 = "123123";//the correct and suitable password
        String situation2 = "321321";//the other's password
        String situation3 = "666666";//the password which doesn't exist in date
        String expected = loginControl.checkID("jp2020213326", "123123");
        assertEquals(expected, loginControl.checkID("jp2020213326",situation1));//scan the wrong ID should not log in
        assertNotEquals(expected, loginControl.checkID("jp2020213326",situation2));//scan the ID should be able to log in
        assertNotEquals(expected, loginControl.checkID("jp2020213326",situation3));//scan the wrong ID should not log in
    }
}
