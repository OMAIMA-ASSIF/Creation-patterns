package net.omaima;

import net.omaima.model.AccountStatus;
import net.omaima.model.AccountType;
import net.omaima.model.BankAccount;
import net.omaima.model.BankDirector;
import net.omaima.repository.AccountRepositoryImpl;
import net.omaima.util.JsonSerializer;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl accountRepository=AccountRepositoryImpl.getInstance();

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                accountRepository.populateData();
            }).start();
        }

        System.out.println("Tap a character");
        System.in.read();

        List<BankAccount> bankAccounts = accountRepository.findAll();
        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);

    }


}