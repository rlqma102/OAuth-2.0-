package com.example.boot3.service;

import com.example.boot3.dto.Member;
import com.example.boot3.enums.Role;
import com.example.boot3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void editRole(String id, String role) {

        Member member = memberRepository.findById(id);

        if(member == null) {
            throw new RuntimeException("회원 없음");
        } else {
            Member updateMember = Member.builder()
                .id(member.getId())
                .oauthId(member.getOauthId())
                .name(member.getName())
                .email(member.getEmail())
                .imageUrl(member.getImageUrl())
                .auth(member.getAuth())
                .password(member.getPassword())
                .role(Role.valueOf(role))
                .build();
            memberRepository.save(updateMember);
        }
    }
}
