package com.nonstop.playground.account.ui;

import com.nonstop.playground.account.application.AccountService;
import com.nonstop.playground.account.application.JwtUserDetailsService;
import com.nonstop.playground.account.domain.Account;
import com.nonstop.playground.account.ui.dto.CreateAccountDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @PostMapping("/v1/user")
    public ResponseEntity<Account> register(@Valid @RequestBody CreateAccountDTO createAccountDTO) {
        return ResponseEntity.ok(accountService.register(createAccountDTO.getUserName(), createAccountDTO.getPassword()));
    }

    @GetMapping("/v1/user/duplicate")
    public Boolean existsByUserName(@RequestParam String userName) {
        return accountService.isDuplicate(userName);
    }
}
