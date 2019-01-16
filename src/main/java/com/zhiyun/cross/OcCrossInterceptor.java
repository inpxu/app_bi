package com.zhiyun.cross;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OcCrossInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	    if(response.getHeader("Access-Control-Allow-Origin")==null){
            response.addHeader("Access-Control-Allow-Origin",
                    request.getHeader("Origin") == null ? "*" : request.getHeader("Origin"));
            response.addHeader("Access-Control-Allow-Methods", "*");
            response.addHeader("Access-Control-Max-Age", "100");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
            response.addHeader("Access-Control-Allow-Credentials", "true");
        }
		return super.preHandle(request, response, handler);
	}

}
