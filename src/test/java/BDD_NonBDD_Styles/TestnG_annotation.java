package BDD_NonBDD_Styles;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestnG_annotation {

    @BeforeTest
    public void tc1()
    {
        System.out.println("1");
    }
    @Test (priority = 0)
    public void tc2()
    {
        System.out.println("2");
    }
    @Test (priority = 2)
    public void tc3()
    {
        System.out.println("3");
    }
    @Test (priority = 3)
    public void tc4()
    {
        System.out.println("4");
    }
}
