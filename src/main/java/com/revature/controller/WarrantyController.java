package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.DeviceWarranty;
import com.revature.model.User;
import com.revature.service.WarrantyService;
import io.javalin.Javalin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class WarrantyController implements Controller{

    private WarrantyService warrantyService;

    public WarrantyController() {
        this.warrantyService = new WarrantyService();
    }
    @Override
    public void mapEndpoints(Javalin app) {
        app.get("/warranties", ctx -> {

            HttpServletRequest req = ctx.req;

            HttpSession session = req.getSession();
            User myUser = (User) session.getAttribute("logged_in_user");

            if (myUser == null) {
                ctx.result("You are not logged in!");
                ctx.status(404);
            } else if (myUser.getPositionRole().equals("hospital_admin")){

                ctx.json(warrantyService.getWarrantiesByUsername(myUser.getUsername()));
                ctx.status(200);
            } else if (myUser.getPositionRole().equals("warranty_manager")) {

                ctx.json(warrantyService.getAllWarranties());
                ctx.status(200);
            }
        });

        app.post("/warranty", ctx -> {
            HttpServletRequest req = ctx.req;

            HttpSession session = req.getSession();
            User myUser = (User) session.getAttribute("logged_in_user");


            if (myUser == null) {
                ctx.result("You are not logged in!");
                ctx.status(404);
            } else if (myUser.getPositionRole().equals("hospital_admin")){

                DeviceWarranty newWarranty = ctx.bodyAsClass(DeviceWarranty.class);
                newWarranty.setWarrantyRequester(myUser.getUsername());
                ctx.json(warrantyService.addNewWarranty(newWarranty));
                ctx.status(201);
            } else {

                ctx.result("You are not logged in as a hospital admin!");
                ctx.status(404);
            }
        });

        app.put("/warranty", ctx -> {
            HttpServletRequest req = ctx.req;

            HttpSession session = req.getSession();
            User myUser = (User) session.getAttribute("logged_in_user");

            if (myUser == null) {
                ctx.result("You are not logged in!");
                ctx.status(404);
            } else if (myUser.getPositionRole().equals("warranty_manager")){
                ObjectMapper om = new ObjectMapper();
                Map<String, String> warranties = om.readValue(ctx.body(), Map.class);
                System.out.println(warranties);
                //DeviceWarranty warrantyUpdate = ctx.bodyAsClass(DeviceWarranty.class);
                String username = myUser.getUsername();
                ctx.json(warrantyService.updateWarranty(warranties, username));
                ctx.status(200);
            } else {

                ctx.result("You are not logged in as a warranty manager!");
                ctx.status(404);
            }
        });
    }
}
