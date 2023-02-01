package com.example.boot3.controller;

import com.example.boot3.dto.Request;
import com.example.boot3.provider.JwtTokenProvider;
import com.example.boot3.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    private final JwtTokenProvider jwtTokenProvider;

    /**
     * 권한 요청 목록 가져오기
     * */
    @GetMapping("api/requests")
    public List<Request> requests(
    ) {
        return adminService.getRequests();
    }

    /**
     * 권한 요청 승인
     */
    @PostMapping("api/accept")
    public String accept(
         @RequestBody Request request
        ,@RequestHeader(value="authorization") String authorization
    ) {
        String subject = jwtTokenProvider.getPayload(authorization); // 현재 사용자 ID
        // TODO 권한 체크........
        String returnRole = adminService.accept(request);
        return returnRole;
    }

    /**
     * 권한 요청 반려
     */
    @PostMapping("api/reject")
    public String reject(
         @RequestBody Request request
        ,@RequestHeader(value="authorization") String authorization
    ) {
        String subject = jwtTokenProvider.getPayload(authorization); // 현재 사용자 ID
        // TODO 권한 체크
        String returnRole = adminService.cancleRoles(request);
        return returnRole;
    }

}
