package com.example.boot3.controller;

import com.example.boot3.dto.Request;
import com.example.boot3.provider.JwtTokenProvider;
import com.example.boot3.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping ("/request")
    public void roleRequest(
         @RequestBody Request request
        ,@RequestHeader(value="authorization") String authorization
    ) {
        String subject = jwtTokenProvider.getPayload(authorization);
        request.setMember_id(Long.parseLong(subject));
        requestService.requestRole(request);
    }

}