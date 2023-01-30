package com.example.boot3.controller;

import com.example.boot3.dto.Member;
import com.example.boot3.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/approveRole")
    public String approveRole(@RequestBody Member member) {
        System.out.println(member.getEmail());
        String returnRole = adminService.ApproveRoles(member);

        return returnRole;
    }

}
