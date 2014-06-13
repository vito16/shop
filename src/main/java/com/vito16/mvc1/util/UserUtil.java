package com.vito16.mvc1.util;

import javax.servlet.http.HttpSession;

import com.vito16.mvc1.common.Constants;
import com.vito16.mvc1.model.User;

/**
 * 用户工具类
 * 
 * @author Vito
 *
 */
public class UserUtil {

    public static final String USER = Constants.LOGIN_USER;

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, User user) {
        session.setAttribute(USER, user);
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static User getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (User) attribute;
    }

}
