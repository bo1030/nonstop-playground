package com.nonstop.playground.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonstop.playground.common.domain.BaseTime;
import com.nonstop.playground.common.util.BcryptUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column
    private String userName;

    @Column
    @JsonIgnore
    private String hashedPassword;

    @Column
    @JsonIgnore
    private String adminYn;

    public User(String userName, String password) {
        this.userName = userName;
        this.hashedPassword = BcryptUtils.encodePassword(password);
    }

    public void giveAdmin() {
        this.adminYn = "Y";
    }

    public void takeAwayAdmin() {
        this.adminYn = "N";
    }
}
