package Annotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {
    @Test
    void xtz() {
        System.out.println("This is XYZ from C2");
    }

    @AfterTest
    void at() {
        System.out.println("This is AfterTest Method");
    }
}
