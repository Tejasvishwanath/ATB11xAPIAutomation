package BDD_NonBDD_Styles;

import org.testng.annotations.Test;

public class TestnG_annotation2 {

    @Test (enabled = true)
    public void tc01()
    {
        System.out.println("step1");
    }
    @Test (enabled = false)
    public void tc02()
    {
        System.out.println("step2");
    }
    @Test (alwaysRun = true)
    public void tc03()
    {
        System.out.println("step3");
    }
    @Test (invocationCount = 3)
    public void tc04()
    {
        System.out.println("step4");
    }


}
