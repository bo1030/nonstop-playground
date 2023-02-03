package com.nonstop.playground.account.application;

import com.nonstop.playground.account.application.exception.UserNameDuplicatedException;
import com.nonstop.playground.account.domain.Account;
import com.nonstop.playground.account.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder bCryptEncoder;

    public boolean isDuplicate(String userName) {
        return accountRepository.existsByUserName(userName);
    }

    public Account register(String userName, String password) {
        if (isDuplicate(userName))
            throw new UserNameDuplicatedException(this.getClass().getSimpleName());

        return accountRepository.save(new Account(userName, bCryptEncoder.encode(password)));
    }
}
