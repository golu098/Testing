package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDiTest {
    @RepeatedTest(5)
//    @Test
    @DisplayName("deposit method")
    public  void testDeposit(BankAccount bankAccount, RepetitionInfo repetition){
//        BankAccount bankAccount=new BankAccount(400,0);
        bankAccount.deposit(500);
        assertEquals(500,bankAccount.getBalance());
        System.out.println("No of Reptition "+repetition.getCurrentRepetition());
    }
}
