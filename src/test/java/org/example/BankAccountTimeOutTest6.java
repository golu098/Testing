package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("Bank Account Class ")
@ExtendWith(BankAccountParameterResolver4.class)
public class BankAccountTimeOutTest6 {
   @Test
   @DisplayName("withdraw method")
   @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    public  void testWithdraw(){
       try{
           Thread.sleep(200);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200,bankAccount.getBalance());
    }
    @Test
    @DisplayName("deposit method")
    public  void testDeposit(){
        BankAccount bankAccount=new BankAccount(400,0);
        bankAccount.deposit(100);
        assertTimeout(Duration.ofMillis(500),()->{
            Thread.sleep(100);
        });
//        assertEquals(900,bankAccount.getBalance());
    }

}
