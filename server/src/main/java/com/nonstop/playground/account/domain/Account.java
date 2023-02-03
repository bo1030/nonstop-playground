package com.nonstop.playground.account.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nonstop.playground.common.domain.BaseTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Account extends BaseTime {
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

    public Account(String userName, String hashedPassword) {
        this.userName = userName;
        this.hashedPassword = hashedPassword;
        this.adminYn = "N";
    }

    public void giveAdmin() {
        this.adminYn = "Y";
    }

    public void takeAwayAdmin() {
        this.adminYn = "N";
    }
}
