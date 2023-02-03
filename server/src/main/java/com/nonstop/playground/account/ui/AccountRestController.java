package com.nonstop.playground.account.ui;

import com.nonstop.playground.account.application.AccountService;
import com.nonstop.playground.account.application.JwtUserDetailsService;
import com.nonstop.playground.account.domain.Account;
import com.nonstop.playground.account.ui.dto.CreateAccountDTO;
import com.nonstop.playground.account.ui.dto.TokenRequest;
import com.nonstop.playground.account.ui.dto.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    private final JwtUserDetailsService jwtUserDetailsService;

    @PostMapping("/v1/account")
    public ResponseEntity<Account> register(@Valid @RequestBody CreateAccountDTO createAccountDTO) {
        return ResponseEntity.ok(accountService.register(createAccountDTO.getUserName(), createAccountDTO.getPassword()));
    }

    @GetMapping("/v1/account/duplicate")
    public Boolean existsByUserName(@RequestParam String userName) {
        return accountService.isDuplicate(userName);
    }

    @PostMapping("v1/account/authenticate")
    public ResponseEntity<TokenResponse> createJwt(TokenRequest loginRequest) {
        return ResponseEntity.ok(accountService.createJwt(loginRequest.getUsername(), loginRequest.getPassword()));
    }
}
