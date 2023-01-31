package com.nonstop.playground.user.infra;

import com.nonstop.playground.user.domain.User;
import com.nonstop.playground.user.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository  extends UserRepository, JpaRepository<User, Long> {
}
