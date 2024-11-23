package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver4.class)
public class BankAccountParallelExecutionTest5 {
   @Test
    @DisplayName("deposit method")
    public  void testDeposit1(BankAccount bankAccount){
       try{
           Thread.sleep(1200);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());

    }
    @Test
    @DisplayName("deposit method")
    public  void testDeposit2(BankAccount bankAccount){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());

    }
    @Test
    @DisplayName("deposit method")
    public  void testDeposit3(BankAccount bankAccount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());

    }
}
