package api.login.loginapi.controller;

import api.login.loginapi.cookie.SetRandomCookie;
import api.login.loginapi.entity.User;
import api.login.loginapi.repository.UserRepository;
import api.login.loginapi.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    Cookie login(
            @ModelAttribute User user,
            HttpServletResponse response) {

        Cookie cookie = new SetRandomCookie().setRandomCookieValue(user);

        response.addCookie(cookie);

        loginService.login(user.getId(), user.getPw());

        return cookie;
    }

    @PostMapping("/logout")
    String logout(User user, HttpServletResponse response){

        Cookie getCookie = login(user, response);
        getCookie.setMaxAge(0);
        response.addCookie(getCookie);
        return "logout";
    }

}
