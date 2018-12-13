package com.esliceu.dwes.xavi.controller;

import com.esliceu.dwes.xavi.Constants;
import com.esliceu.dwes.xavi.model.User;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = {"home"})
public class SessionFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession(false);

        RequestDispatcher requestDispatcher =  req.getRequestDispatcher(Constants.INDEX_URL);

        if (session == null) {
            requestDispatcher.forward(req,res);
        } else {

            User user = (User) session.getAttribute(Constants.USER_SESSION);

            if (user == null) {
                requestDispatcher.forward(req,res);
            } else {
                chain.doFilter(req, res);
            }

        }

    }
}
