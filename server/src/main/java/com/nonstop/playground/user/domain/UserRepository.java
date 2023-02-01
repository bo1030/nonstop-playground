package com.nonstop.playground.user.domain;

public interface UserRepository {
    boolean existsByUserName(String userName);
    User save(User user);
}
