package com.example.jwt.member;

import com.example.jwt.member.dto.SignUpDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;


    private Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Member of(SignUpDto sign) {

        Member member = new Member(sign.getName(), sign.getEmail(), sign.getPassword());

        return member;
    }

}
