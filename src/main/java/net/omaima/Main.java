package net.omaima;

import net.omaima.model.AccountStatus;
import net.omaima.model.AccountType;
import net.omaima.model.BankAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount account2=new BankAccount(3L,6500,"MAD",AccountType.SAVING_ACCOUNT,AccountStatus.CREATED);
                System.out.println(account2);


        BankAccount account=new BankAccount();
        account.setAccountId(2L);
        account.setType(AccountType.SAVING_ACCOUNT);
        account.setStatus(AccountStatus.CREATED);
        account.setCurrency("MAD");

        System.out.println(account);


        BankAccount bankAccount= BankAccount.builder()
                .accountId(1L)
                .currency("MAD")
                .status(AccountStatus.CREATED)
                .type(AccountType.SAVING_ACCOUNT)
                .balance(70000)
                .build();
        System.out.println(bankAccount.toString());
    }
}