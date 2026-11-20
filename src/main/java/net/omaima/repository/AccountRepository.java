package net.omaima.repository;

import net.omaima.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface AccountRepository {
    BankAccount save(BankAccount bankAccount);
    List<BankAccount> findAll();
    Optional<BankAccount> findById(Long id);
    List<BankAccount> searchAccount(Predicate<BankAccount> predicate);
    BankAccount update(BankAccount bankAccount);
    void deleteById(Long id);

}
