package api.login.loginapi.cookie;

import api.login.loginapi.entity.User;

import javax.servlet.http.Cookie;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class SetRandomCookie {
    RandomCookieValueGenerator cookieValueGenerator = new RandomCookieValueGenerator();

    public Cookie setRandomCookieValue(User user) {
        String cookieValue = cookieValueGenerator.generate();
        cookieValue = URLEncoder.encode(cookieValue, StandardCharsets.UTF_8);

        Cookie cookie = new Cookie(user.getId() +"_Cookie", cookieValue);
        cookie.setMaxAge(600);
        return cookie;
    }
}
