package com.example.boot3.controller;

import com.example.boot3.dto.Member;
import com.example.boot3.dto.Request;
import com.example.boot3.repository.RequestRepository;
import com.example.boot3.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    @Autowired
    RequestRepository requestRepository;

    @PostMapping("/approveRole")
    public String approveRole(@RequestBody Member member) {
        System.out.println(member.getEmail());
        String returnRole = adminService.ApproveRoles(member);

        return returnRole;
    }

    //요청 목록 가져오기
    @GetMapping("api/approv")
    public List<Request> getRequests() {
        List<Request> requests = requestRepository.findAll();
        System.out.println(requests);

        return requests;
    }

}
