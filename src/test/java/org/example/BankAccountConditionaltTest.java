package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class BankAccountConditionaltTest {
    @Test
    @EnabledOnOs({OS.MAC})
    public void testMac(){

    }
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public  void testWindow(){

    }
    @Test
    @EnabledOnOs({OS.LINUX})
    public void testLinux(){

    }
    @Test
    @EnabledOnJre(JRE.JAVA_22)
    public void testJRE(){

    }
    @Test
    @DisabledOnJre(JRE.JAVA_10)
    public  void testJRE1(){

    }

}
