package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSofAssertions {
    @Test
    void testHardAssertions() {
        System.out.println("Testing");
        System.out.println("Testing");

        Assert.assertEquals(1, 3);

        System.out.println("Testing");
        System.out.println("Testing");
    }

    @Test
    void testSoftAssertions() {
        System.out.println("Testing");
        System.out.println("Testing");

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(1, 3);

        System.out.println("Testing");
        System.out.println("Testing");

        sa.assertAll();
    }
}
