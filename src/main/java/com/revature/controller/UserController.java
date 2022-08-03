package com.revature.controller;

import com.revature.exception.InvalidLoginException;
import com.revature.model.User;
import com.revature.service.UserService;
import io.javalin.Javalin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class UserController implements Controller {

    private UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @Override
    public void mapEndpoints(Javalin app) {
        app.post("/login", ctx -> {
            User user = ctx.bodyAsClass(User.class);

            String username = user.getUsername();
            String userPassword = user.getUserPassword();

            try {
                User loggedInUser = userService.login(username, userPassword);

                HttpServletRequest req = ctx.req;
                HttpSession session = req.getSession();
                session.setAttribute("logged_in_user", loggedInUser);

                ctx.json(loggedInUser);
            } catch (InvalidLoginException | SQLException e) {
                ctx.result(e.getMessage());
                ctx.status(400);
            }
        });
    }

}
