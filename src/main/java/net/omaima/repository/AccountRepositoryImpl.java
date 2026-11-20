package net.omaima.repository;

import net.omaima.model.AccountStatus;
import net.omaima.model.AccountType;
import net.omaima.model.BankAccount;
import net.omaima.model.BankDirector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
    private Map<Long , BankAccount> bankAccountMap = new HashMap<>();
    private long accountsCount = 0;

    private static final AccountRepositoryImpl accountRepository;
    static {
        System.out.println("Singleton instantiation");
        accountRepository=new AccountRepositoryImpl();
    }

    private AccountRepositoryImpl(){};

    @Override
    public synchronized BankAccount save(BankAccount bankAccount) {

        Long accountId;
        bankAccount.setAccountId(accountId);
        bankAccountMap.put(accountId,bankAccount);
        return bankAccount;
    }

    @Override
    public List<BankAccount> findAll() {
        return bankAccountMap.values().stream().toList();
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        BankAccount account=bankAccountMap.get(id);
        if(account==null)
            return Optional.empty();
        else
            return Optional.of(account);
    }


    @Override
    public List<BankAccount> searchAccounts(Predicate<BankAccount> predicate) {
        return bankAccountMap.values().stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public BankAccount update(BankAccount account) {
        bankAccountMap.put(account.getAccountId(),account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        bankAccountMap.remove(id);
    }

    public synchronized void populateData(){
        for (int i = 0; i < 10 ; i++) {
            BankAccount account = BankDirector.accountBuilder()
                    .balance(10000+Math.random()*90000)
                    .type(Math.random()>0.5?AccountType.SAVING_ACCOUNT: AccountType.CURRENT_ACCOUNT)
                    .status(Math.random()>0.5? AccountStatus.CREATED:AccountStatus.ACTIVATED)
                    .currency(Math.random()>0.5?"MAD":"USD")
                    .build();
            save(account);
        }

        System.out.println("**********************************");
        System.out.println(Thread.currentThread().getName());
        System.out.println("Account Count = "+accountsCount);
        System.out.println("Size:"+bankAccountMap.values().size());
        System.out.println("**********************************");
    }

    public static AccountRepositoryImpl getInstance(){
        return accountRepository;
    }
}
