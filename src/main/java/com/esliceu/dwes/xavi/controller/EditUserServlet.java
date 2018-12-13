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
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "edit",value = "/edit")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("id");

        EntityManager<User> userManager = (EntityManager<User>) SpringContext.getInstance().getBean("userManager");
        User userItem = Constants.createUser();
        userItem.setEmail(userId);
        User user = userManager.getItemById(userItem);

        req.setAttribute("user", user);


        req.getRequestDispatcher(Constants.EDIT_VIEW_URL).forward(req,resp);

    }
}
