package com.nonstop.playground.account.infra;

import com.nonstop.playground.account.domain.Account;
import com.nonstop.playground.account.domain.AccountRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJpaRepository extends AccountRepository, JpaRepository<Account, Long> {
    boolean existsByUserName(String userName);

    Account save(Account user);

    Optional<Account> findById(long id);

    Account findByUserName(String userName);
}
