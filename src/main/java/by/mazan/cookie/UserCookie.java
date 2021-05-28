package by.mazan.cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCookie {

    public void addCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie nameCookie = new Cookie("name", request.getParameter("user"));
        Cookie passwordCookie = new Cookie("password", request.getParameter("password"));
        nameCookie.setMaxAge(24 * 60 * 60);
        passwordCookie.setMaxAge(24 * 60 * 60);
        nameCookie.setPath("/");
        passwordCookie.setPath("/");
        response.addCookie(nameCookie);
        response.addCookie(passwordCookie);
    }

    public void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
