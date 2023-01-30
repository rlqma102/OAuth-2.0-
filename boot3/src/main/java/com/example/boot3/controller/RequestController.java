package com.example.boot3.controller;

import com.example.boot3.dto.Request;
import com.example.boot3.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    @PostMapping ("/join")
    public void roleRequest(@RequestBody Request request) {

        System.out.println(request.getEmail());
        System.out.println(request.getRole());

        requestService.requestRole(request);

        //리퀘스트 서비스에 있는 함수 호출해서 리퀘스트에 담긴 내용이 인서트 되도록
        //서비스에서 날짜랑 상태를 설정하고 인서트한다

    }



}