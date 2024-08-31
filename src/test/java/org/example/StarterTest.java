package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StarterTest {
    @Test
    public  void smaple(){
        Starter obj=new Starter();
        assertEquals("Hello World",obj.StarterMethod());
    }
}
