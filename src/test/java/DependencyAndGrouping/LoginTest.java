package DependencyAndGrouping;

import org.testng.annotations.Test;

public class LoginTest {
    @Test(priority = 1, groups = {"sanity"})
    void loginByEmail() {
        System.out.println("This is login by Email");
    }

    @Test(priority = 2, groups = {"sanity"})
    void loginByFacebook() {
        System.out.println("This is login by Facebook");
    }

    @Test(priority = 3, groups = {"sanity"})
    void loginByTwitter() {
        System.out.println("This is login by Twitter");
    }
}
