package DependencyAndGrouping;

import org.testng.annotations.Test;

public class PaymentTests {
    @Test(priority = 1, groups = {"regression", "sanity", "functional"})
    void paymentRupees() {
        System.out.println("Payment in rupees");
    }

    @Test(priority = 2, groups = {"regression", "sanity", "functional"})
    void paymentDollars() {
        System.out.println("Payment in Dollars");
    }
}
