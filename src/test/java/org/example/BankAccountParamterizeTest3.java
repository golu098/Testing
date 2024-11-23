package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

@ExtendWith(BankAccountParameterResolver4.class)
public class BankAccountParamterizeTest3 {
//    @RepeatedTest(5)
//    @Test
    @ParameterizedTest
    @ValueSource(ints = {200,2001,290,839})
    @DisplayName("deposit method")
    public  void testDeposit(int amount,BankAccount bankAccount){
//        BankAccount bankAccount=new BankAccount(400,0);
        bankAccount.deposit(amount);
        assertEquals(amount,bankAccount.getBalance());
       // System.out.println("No of Reptition "+repetition.getCurrentRepetition());
    }
    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"})
    public void testOfWeek(DayOfWeek day) {
        assertTrue(day.toString().startsWith("T"));
    }
    @ParameterizedTest
    @CsvSource({"100,Shivkant", "200,Golu",})
//    @CsvFileSource(resources = "name.csv")
    public void depositNameTest(double amount,String name,BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setHoldername(name);
        assertEquals(amount,bankAccount.getBalance());
        assertEquals(name,bankAccount.getHoldername());
    }
}
