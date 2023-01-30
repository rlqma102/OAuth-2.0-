package com.example.boot3.service;

import com.example.boot3.dto.Member;
import com.example.boot3.dto.Request;
import com.example.boot3.enums.Role;
import com.example.boot3.repository.MemberRepository;
import com.example.boot3.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final MemberRepository memberRepository;
    private final RequestRepository requestRepository;

    public String ApproveRoles(Member member) {

        Request request = requestRepository.findByEmail(member.getEmail());

        request.setRqStatus('Y');
        request.setOkDate(LocalDateTime.now());

        String role = "";

        if (Role.GUEST.equals(request.getRole())) {
            role = "GUEST";
        } else if(Role.USER.equals(request.getRole())) {
            role = "USER";
        } else if(Role.ADMIN.equals(request.getRole())) {
            role = "ADMIN";
        } else {
            role = "CAT";
        }

        requestRepository.save(request);

        Member updateMember = memberRepository.findByEmail(member.getEmail());

        updateMember.setRole(request.getRole());

        memberRepository.save(updateMember);

        return role;
    }

}
