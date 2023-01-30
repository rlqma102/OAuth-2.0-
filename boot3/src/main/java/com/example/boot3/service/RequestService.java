package com.example.boot3.service;

import com.example.boot3.dto.Member;
import com.example.boot3.dto.Request;
import com.example.boot3.repository.MemberRepository;
import com.example.boot3.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;
    private final MemberRepository memberRepository;

    public void requestRole(Request request) {

        Member member = memberRepository.findByEmail(request.getEmail());

            Request requestRole = Request.builder()
                    .email(request.getEmail())
                    .role(request.getRole())
                    .createDate(LocalDateTime.now())
                    .okDate(null)
                    .rqStatus('P')
                            .build();
            requestRepository.save(requestRole);

    }
}
