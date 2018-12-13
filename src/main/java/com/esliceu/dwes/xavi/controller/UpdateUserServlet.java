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

@WebServlet(name = "update-user", value = "/update")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String familyName = req.getParameter("familyName");
        String email = req.getParameter("email");
        String photo = req.getParameter("photo");

        EntityManager<User> userManager = (EntityManager<User>) SpringContext.getInstance().getBean("userManager");
        User userItem = Constants.createUser();
        userItem.setEmail(email);
        User user = userManager.getItemById(userItem);

        user.setName(name);
        user.setFamilyName(familyName);
        user.setPhoto(photo);

        userManager.updateItem(user);

        req.setAttribute("users", userManager.getAll());

        req.getRequestDispatcher(Constants.HOME_VIEW_URL).forward(req,resp);
    }
}
