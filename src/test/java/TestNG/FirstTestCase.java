package TestNG;

import org.testng.annotations.Test;

public class FirstTestCase {

    @Test(priority = 3)
    void logout() {
        System.out.println("Logout from application.....");
    }

    @Test(priority = 1)
    void openApp() {
        System.out.println("Opening Application.....");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("Login to application.....");
    }
}

