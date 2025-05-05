package Annotations;

import org.testng.annotations.*;

public class AllAnnotations {
    @BeforeSuite
    void bs() {
        System.out.println("This is before Suite..");
    }

    @AfterSuite
    void as() {
        System.out.println("This is after Suite..");
    }

    @BeforeTest
    void bt() {
        System.out.println("This is before test method..");
    }

    @AfterTest
    void at() {
        System.out.println("This is after test method..");

    }

    @BeforeClass
    void bc() {
        System.out.println("This is before class method..");
    }

    @AfterClass
    void ac() {
        System.out.println("This is after class method..");
    }

    @BeforeMethod
    void bm() {
        System.out.println("This is before method");
    }

    @AfterMethod
    void am() {
        System.out.println("This is after method..");
    }

    @Test(priority = 1)
    void tm1() {
        System.out.println("This is Test Method1..");
    }

    @Test(priority = 2)
    void tm2() {
        System.out.println("This is test method2..");
    }
}
