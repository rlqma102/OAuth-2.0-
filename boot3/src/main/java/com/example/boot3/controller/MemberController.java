package com.example.boot3.controller;

import com.example.boot3.provider.JwtTokenProvider;
import com.example.boot3.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    private final JwtTokenProvider jwtTokenProvider;

    //등업(회원롤 수정)
    @PutMapping("/edit-role/{id}")
    public void editRole(
         @PathVariable String id
        ,@RequestParam(required=false) String role // localhost:8080/edit-role/{id}?role=전달값
        ,@RequestHeader(value="authorization") String authorization
    ) { //로그인사용자정보 필요(admin인지 확인 용도)
        String subject = jwtTokenProvider.getPayload(authorization); // 현재 사용자 ID
        // todo 권한 체크........
        memberService.editRole(id, role);
    }


}
