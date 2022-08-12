package com.revature;

import com.revature.controller.Controller;
import com.revature.controller.UserController;
import com.revature.controller.WarrantyController;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.enableCorsForAllOrigins();
        });

        Controller[] controllers = { new UserController(), new WarrantyController()};

        for (int i = 0; i <controllers.length; i++) {
            controllers[i].mapEndpoints(app);
        }

        app.start(8080);
    }
}