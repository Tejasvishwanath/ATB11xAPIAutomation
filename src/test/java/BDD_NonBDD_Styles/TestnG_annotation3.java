package BDD_NonBDD_Styles;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestnG_annotation3 {

    @Parameters ("browser")
    @Test
    public void tcc1( String value)
    {
        System.out.println("Begin in the firefox browser");
    }



}
