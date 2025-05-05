package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {
    @Test
    void testTitle() {
        String exp_title = "Opencart";
        String act_title = "Opencart";


        Assert.assertEquals(exp_title, act_title);
    }
}
