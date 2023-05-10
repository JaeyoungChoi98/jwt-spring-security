package com.example.jwt.member;

import com.example.jwt.member.dto.MemberResponseDto;
import com.example.jwt.member.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponseDto saveMember(SignUpDto sign) {

        Member member = Member.of(sign);

        memberRepository.save(member);

        return MemberResponseDto.of(member);
    }
}
