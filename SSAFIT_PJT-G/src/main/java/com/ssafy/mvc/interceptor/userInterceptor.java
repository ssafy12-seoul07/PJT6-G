package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Component
public class userInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();

        // 요청 URI가 "/api"로 시작하고 세션에 로그인된 사용자가 없는 경우
        if (requestURI.startsWith("/api") && session.getAttribute("User") == null) {
            // 로그인 상태가 아니면 "/api-user"로 리다이렉트
            response.sendRedirect("/api-user"); 
            return false;
        }
        
        // URI가 "/api"로 시작하지 않거나 사용자가 로그인되어 있는 경우 접근 허용
        return true;
    }
}
