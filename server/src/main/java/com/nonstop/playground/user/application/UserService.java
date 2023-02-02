package com.nonstop.playground.user.application;

import com.nonstop.playground.user.application.exception.UserNameDuplicatedException;
import com.nonstop.playground.user.domain.User;
import com.nonstop.playground.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean isDuplicate(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public User register(String userName, String password) {
        if (isDuplicate(userName))
            throw new UserNameDuplicatedException(this.getClass().getSimpleName());

        return userRepository.save(new User(userName,password));
    }
}
