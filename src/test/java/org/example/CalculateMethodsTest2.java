package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateMethodsTest2 {
    private CalculateMethods calculateMethods;
    @BeforeEach

    @Test
    public void initTest(){
        calculateMethods=new CalculateMethods();
        System.out.println("hi");
    }
    @Test
    public  void testDivide(){
        assertEquals(10,calculateMethods.divide(100,10));
    }
    @Test
    public  void testDivideByZero(){
        assertThrows(ArithmeticException.class,()->calculateMethods.divide(100,0));
    }
}
// u can remove Assertion by putting
   // import  org.junit.jupiter.api.Assertions;
//import static org.junit.jupiter.api.Assertions.*;