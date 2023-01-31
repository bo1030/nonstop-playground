package com.nonstop.playground.user.domain;

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
public class User extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    @JsonIgnore
    private String hashedPassword;

    @Column
    @JsonIgnore
    private String adminYn;
}
