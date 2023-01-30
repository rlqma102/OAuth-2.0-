package com.example.boot3.service;

import com.example.boot3.dto.Member;
import com.example.boot3.enums.Role;
import com.example.boot3.repository.MemberRepository;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void editRole(String id, Session session) {
        //여기 위에서 현재 로그인한 사용자가 어드민인지 아닌지 체크해주는거 빠졌음.

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
                    .role(Role.USER).build();
            memberRepository.save(updateMember);
        }
    }
}
