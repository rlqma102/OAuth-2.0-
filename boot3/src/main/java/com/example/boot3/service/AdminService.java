package com.example.boot3.service;

import com.example.boot3.dto.Member;
import com.example.boot3.dto.Request;
import com.example.boot3.repository.MemberRepository;
import com.example.boot3.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final MemberRepository memberRepository;
    private final RequestRepository requestRepository;

    public List getRequests() {
        return requestRepository.findAll();
    }
    public String accept(Request prm) {
        String result = "";

        Optional<Request> request = requestRepository.findById(prm.getId()); // 요청한 정보
        if ( request.isPresent() ) {
            Request req = request.get();
            req.setRqStatus('Y');
            req.setOkDate(LocalDateTime.now());
            requestRepository.save(req);

            Member member = memberRepository.findByEmail(req.getEmail()); // 사용자
            Member updateMember = memberRepository.findByEmail(member.getEmail());
            updateMember.setRole(req.getRq_role());
            memberRepository.save(updateMember);

            result = req.getRq_role().getKey();
        }

        return result;
    }


    //권한 요청 반려하기
    public String cancleRoles(Request prm) {
        String result = "";

        Optional<Request> request = requestRepository.findById(prm.getId()); // 요청한 정보
        if ( request.isPresent() ) {
            Request req = request.get();
            req.setRqStatus('N');
            req.setOkDate(LocalDateTime.now());
            requestRepository.save(req);

            result = req.getRq_role().getKey();
        }

        return result;
    }

}
