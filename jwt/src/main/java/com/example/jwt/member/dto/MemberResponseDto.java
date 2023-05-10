package com.example.jwt.member.dto;

import com.example.jwt.member.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponseDto {

    private String name;

    private String email;

    public static MemberResponseDto of(Member member) {

        MemberResponseDto responseDto = new MemberResponseDto(member.getName(), member.getEmail());

        return responseDto;
    }
}
