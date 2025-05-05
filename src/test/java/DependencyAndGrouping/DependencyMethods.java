package DependencyAndGrouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {
    @Test(priority = 1)
    void testOpenApp() {
        Assert.assertTrue(true);
    }

    @Test(priority = 2, dependsOnMethods = {"testOpenApp"})
    void testLogin() {
        Assert.assertTrue(true);
    }

    @Test(priority = 3, dependsOnMethods = {"testLogin"})
    void testSearch() {
        Assert.fail();
    }

    @Test(priority = 4, dependsOnMethods = {"testLogin", "testSearch"})
    void testAdvancedSearch() {
        Assert.assertTrue(true);
    }

    @Test(priority = 5, dependsOnMethods = {"testLogin"})
    void testLogout() {
        Assert.assertTrue(true);
    }
}
