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

@WebServlet(name = "remove", value = "/remove")
public class RemoveUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("id");

        EntityManager<User> entityManager = (EntityManager<User>) SpringContext.getInstance().getBean("userManager");

        String error = "";
        try {

            User user = Constants.createUser();
            user.setEmail(userId);
            entityManager.deleteById(user);
        } catch (Exception e) {
            error = e.getMessage();
            e.printStackTrace();
        }

        req.setAttribute("error",error);
        req.setAttribute("users", entityManager.getAll());

        req.getRequestDispatcher(Constants.HOME_VIEW_URL).forward(req,resp);




    }
}
