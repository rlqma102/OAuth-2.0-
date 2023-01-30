//package com.example.boot3.adapter;
//
//import com.example.boot3.dto.Member;
//import com.example.boot3.enums.Auth;
//import com.example.boot3.service.MemberService;
//import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//
//@RequiredArgsConstructor
//@Slf4j
//public class AuthInterceptor implements HandlerInterceptor {
//
//    private final MemberService memberService;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        if(!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
//        if(auth == null) {
//            return true;
//        }
//        Long memberId =
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.debug("==================== END ======================");
//        log.debug("===============================================");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//
//}
