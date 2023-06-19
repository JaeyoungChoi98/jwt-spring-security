package com.example.jwt.member;

import com.example.jwt.member.dto.MemberResponseDto;
import com.example.jwt.member.dto.SignUpDto;

import com.example.jwt.utils.CustomAuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //비번 생성기
    private final PasswordEncoder passwordEncoder;

    //역할 부여
    private final CustomAuthorityUtils customAuthorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils customAuthorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.customAuthorityUtils = customAuthorityUtils;
    }

    public MemberResponseDto saveMember(SignUpDto sign) {

        String encryptedPassword = passwordEncoder.encode(sign.getPassword());
        List<String> roles = customAuthorityUtils.createRole(sign.getEmail());

        Member member = Member.of(sign, encryptedPassword, roles);

        memberRepository.save(member);

        return MemberResponseDto.of(member);
    }
}
