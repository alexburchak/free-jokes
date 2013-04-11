package org.translations.web.util;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class RequestUtil {
    private RequestUtil() {
    }

    public static void setCookie(HttpServletResponse response, String name, String value, String path) {
        Assert.notNull(response, "response is null");
        Assert.notNull(name, "name is null");
        Assert.notNull(value, "value is null");

        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(false);
        cookie.setPath(path);
        cookie.setMaxAge(3600 * 24 * 30); // 30 days

        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Assert.notNull(request, "request is null");
        Assert.notNull(name, "name is null");

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie thisCookie : cookies) {
            if (thisCookie.getName().equals(name) && !StringUtils.isEmpty(thisCookie.getValue())) {
                return thisCookie;
            }
        }

        return null;
    }

    public static void deleteCookie(HttpServletResponse response, Cookie cookie, String path) {
        Assert.notNull(response, "response is null");
        Assert.notNull(cookie, "cookie is null");
        Assert.notNull(path, "path is null");

        cookie.setMaxAge(0);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
}
