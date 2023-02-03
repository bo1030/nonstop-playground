package com.nonstop.playground.account.application;

import com.nonstop.playground.account.domain.Account;
import com.nonstop.playground.account.domain.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findById(Long.parseLong(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with userid " + username));

        return new User(user.getId().toString(), user.getHashedPassword(), new ArrayList<>());
    }
}
