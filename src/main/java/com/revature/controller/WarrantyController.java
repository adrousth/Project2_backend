package com.revature.controller;

import com.revature.model.User;
import com.revature.service.WarrantyService;
import io.javalin.Javalin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class WarrantyController implements Controller{

    private WarrantyService warrantyService;

    public WarrantyController() {
        this.warrantyService = new WarrantyService();
    }
    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/warranties", ctx -> {
            System.out.println("warranties");
            HttpServletRequest req = ctx.req;

            HttpSession session = req.getSession();
            User myUser = (User) session.getAttribute("logged_in_user"); // Downcast the Object return type to User
            // The underlying object is still a User object
            System.out.println(myUser);
            if (myUser == null) {
                ctx.result("You are not logged in!");
                ctx.status(404);
            } else if (myUser.getPositionRole().equals("hospital_admin")){
                System.out.println("hospital admin warranties");
                ctx.json(warrantyService.getWarrantiesByUsername(myUser.getUsername()));
                ctx.status(200);
            } else if (myUser.getPositionRole().equals("warranty_manager")) {
                System.out.println("warranty manager warranties");
                ctx.json(warrantyService.getAllWarranties());
                ctx.status(200);
            }
        });
    }
}
