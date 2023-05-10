package com.example.jwt.member;

import com.example.jwt.member.dto.MemberResponseDto;
import com.example.jwt.member.dto.SignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public ResponseEntity<MemberResponseDto> createMember(@RequestBody SignUpDto sign) {

        MemberResponseDto memberResponseDto = memberService.saveMember(sign);

        return ResponseEntity.ok(memberResponseDto);
    }

}
