package com.steins.filter;

import com.steins.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName ="LoginFilter",value = {"/index.jsp"},dispatcherTypes = {DispatcherType.REQUEST})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session=request.getSession();
//        User member=(User)session.getAttribute("user");
//        if(member==null){
//            try{
//                String message="您无权操作,请登录";
//                String jsonMessage="";
//
//                jsonMessage = "{\"success\": false ,\"errMsg\":\"" + message + "\"}";
//                resp.getWriter().write(jsonMessage.toString());
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//             return;
//        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
