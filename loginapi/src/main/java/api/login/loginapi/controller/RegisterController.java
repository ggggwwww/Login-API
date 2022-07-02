package api.login.loginapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @PostMapping("/register")
    String registerUser(){

        return "";
    }
}
