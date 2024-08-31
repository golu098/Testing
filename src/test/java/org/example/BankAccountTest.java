package org.example;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("Bank Account Class ")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankAccountTest {
   @Test
   @DisplayName("withdraw method")
    public  void testWithdraw(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(300);
        assertEquals(200,bankAccount.getBalance());
    }
    @Test
    @DisplayName("deposit method")
    public  void testDeposit(){
        BankAccount bankAccount=new BankAccount(400,0);
        bankAccount.deposit(100);

        assertEquals(900,bankAccount.getBalance());
    }
    @Test
    @DisplayName("deposit method")
    public  void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount=new BankAccount(500,-1000);
        bankAccount.withdraw(800);

        assertNotEquals(0,bankAccount.getBalance());
    }
@Test
@DisplayName("Test Activation account after Creation")
    public void testActive(){
       BankAccount bankAccount=new BankAccount(500,0);
      assumeFalse(bankAccount==null);
       assertTrue(bankAccount.isActive());
    }
    @Test
    @DisplayName("test holder name")
    @Order(1)
    public void testHolder(){
    BankAccount bankAccount=new BankAccount(500,0);
    bankAccount.setHoldername("Shiv kant");
    assertNotNull(bankAccount.getHoldername());
    }
    @Test
    @DisplayName("There is restriction that you can not withdraw if you have minimu limit amount reached")
    @Order(2)
    public  void minimumAmountNoWithdraw(){
       BankAccount bankAccount=new BankAccount(1000,2000);
       assertThrows(Exception.class,()->bankAccount.withdraw(20000));

    }
    @Test
    @DisplayName("Test no exceptionn for withdraw and deposit")
    public void testwithdrawWithoutExceptions(){
       BankAccount bankAccount=new BankAccount(500,-1000);
       assertAll(()->bankAccount.deposit(200),()->bankAccount.withdraw(4500));
   }

}
