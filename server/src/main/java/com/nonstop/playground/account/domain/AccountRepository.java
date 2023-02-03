package com.nonstop.playground.account.domain;

import java.util.Optional;

public interface AccountRepository {
    boolean existsByUserName(String userName);
    Account save(Account user);

    Optional<Account> findById(long id);

    Optional<Account> findByUserName(String userName);
}
