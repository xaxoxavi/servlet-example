package com.esliceu.dwes.xavi.controller;

import com.esliceu.dwes.xavi.Constants;
import com.esliceu.dwes.xavi.SpringContext;
import com.esliceu.dwes.xavi.model.User;
import com.esliceu.dwes.xavi.modules.Authenticator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("useridentifier");
        String password = req.getParameter("password");

        User user = (User) SpringContext.getInstance().getBean("user");
        user.setEmail(userId);
        user.setPassword(password);

        Authenticator authenticator = (Authenticator) SpringContext.getInstance().getBean("authenticator");

        RequestDispatcher requestDispatcher;

        if (authenticator.authenticate(user)) {
            HttpSession session = req.getSession(true);
            session.setAttribute(Constants.USER_SESSION, user);

            requestDispatcher = req.getRequestDispatcher(Constants.HOME_URL);
        } else {
            requestDispatcher = req.getRequestDispatcher(Constants.INDEX_URL);
        }


        requestDispatcher.forward(req,resp);
    }


}
