package com.example.jwt.member;

import com.example.jwt.member.dto.SignUpDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter //보안때문에 생김
@NoArgsConstructor(access = AccessLevel.PROTECTED) //memberDetails에서 생성이 안돼서 protected
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    //멤버 역할 추가
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    private Member(String name, String email, String password, List<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public static Member of(SignUpDto sign, String password, List<String> roles) {

        Member member = new Member(sign.getName(), sign.getEmail(), password, roles);

        return member;
    }

}
