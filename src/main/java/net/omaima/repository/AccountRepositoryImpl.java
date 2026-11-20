package net.omaima.repository;

import net.omaima.model.BankAccount;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AccountRepositoryImpl implements AccountRepository {
    @Override
    public BankAccount save(BankAccount bankAccount) {
        return null;
    }

    @Override
    public List<BankAccount> findAll() {
        return List.of();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<BankAccount> searchAccount(Predicate<BankAccount> predicate) {
        return List.of();
    }

    @Override
    public BankAccount update(BankAccount bankAccount) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
