package DependencyAndGrouping;

import org.testng.annotations.Test;

public class SignUpTest {
    @Test(priority = 1, groups = {"regression"})
    void signupByEmail() {
        System.out.println("This is signup by Email");
    }

    @Test(priority = 2, groups = {"regression"})
    void signupByFacebook() {
        System.out.println("This is signup by Facebook");
    }

    @Test(priority = 3, groups = {"regression"})
    void signupByTwitter() {
        System.out.println("This is signup by Twitter");
    }
}
