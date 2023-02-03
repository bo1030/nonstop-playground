package com.nonstop.playground.account.application;

import com.nonstop.playground.account.application.exception.UserNameDuplicatedException;
import com.nonstop.playground.account.domain.Account;
import com.nonstop.playground.account.domain.AccountRepository;
import com.nonstop.playground.account.ui.dto.TokenResponse;
import com.nonstop.playground.common.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder bCryptEncoder;

    private final JwtTokenUtil jwtTokenUtil;

    private final AuthenticationManager authenticationManager;

    public boolean isDuplicate(String userName) {
        return accountRepository.existsByUserName(userName);
    }

    public Account register(String userName, String password) {
        if (isDuplicate(userName))
            throw new UserNameDuplicatedException(this.getClass().getSimpleName());

        return accountRepository.save(new Account(userName, bCryptEncoder.encode(password)));
    }

    public TokenResponse createJwt(String username, String password) {
        String userId = accountRepository.findByUserName(username).getId().toString();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));

        return new TokenResponse(jwtTokenUtil.generateToken(new User(userId, password, new ArrayList<>())));
    }
}
