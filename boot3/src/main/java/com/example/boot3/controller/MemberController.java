package com.example.boot3.controller;

import com.example.boot3.service.MemberService;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    //등업(회원롤 수정)
    @PutMapping("/edit-role/{id}")
    public void editRole(@PathVariable String id, Session session) { //로그인사용자정보 필요(admin인지 확인 용도)
        memberService.editRole(id, session);
    }


}
