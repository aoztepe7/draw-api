package com.ztp.raffleapi.domain.user;

import com.ztp.raffleapi.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "prefix",nullable = false)
    private String prefix;

    @Column(name = "mail",nullable = false)
    private String mail;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
