package com.nonstop.playground.user.ui;

import com.nonstop.playground.user.application.UserService;
import com.nonstop.playground.user.domain.User;
import com.nonstop.playground.user.ui.dto.CreateUserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/v1/user")
    public ResponseEntity<User> register(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return ResponseEntity.ok(userService.register(createUserDTO.getUserName(), createUserDTO.getPassword()));
    }

    @GetMapping("/v1/user/duplicate")
    public Boolean existsByUserName(@RequestParam String userName) {
        return userService.isDuplicate(userName);
    }
}
