package com.esliceu.dwes.xavi.controller;

import com.esliceu.dwes.xavi.Constants;
import com.esliceu.dwes.xavi.SpringContext;
import com.esliceu.dwes.xavi.model.User;
import com.esliceu.dwes.xavi.modules.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "home", value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EntityManager userManager = (EntityManager) SpringContext.getInstance().getBean("userManager");

        req.setAttribute("users",userManager.getAll());

        req.getRequestDispatcher(Constants.HOME_VIEW_URL).forward(req,resp);
    }
}
