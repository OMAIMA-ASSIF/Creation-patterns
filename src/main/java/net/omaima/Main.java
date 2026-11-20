package net.omaima;

import net.omaima.model.AccountStatus;
import net.omaima.model.AccountType;
import net.omaima.model.BankAccount;
import net.omaima.model.BankDirector;
import net.omaima.repository.AccountRepositoryImpl;
import net.omaima.util.JsonSerializer;

import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JsonSerializer<BankAccount> bankAccountJsonSerializer=new JsonSerializer<>();
        AccountRepositoryImpl accountRepository=AccountRepositoryImpl.getInstance();
        accountRepository.populateData();
        List<BankAccount> bankAccounts = accountRepository.searchAccounts(bankAccount -> bankAccount.getType().equals(AccountType.CURRENT_ACCOUNT));

        bankAccounts.stream()
                .map(bankAccountJsonSerializer::toJson)
                .forEach(System.out::println);

    }


}