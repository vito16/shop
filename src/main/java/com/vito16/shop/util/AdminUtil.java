package com.vito16.shop.util;

import com.vito16.shop.common.Constants;
import com.vito16.shop.model.Admin;
import com.vito16.shop.model.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import javax.servlet.http.HttpSession;

/**
 * 管理员工具类
 * 
 * @author Vito
 *
 */
public class AdminUtil {

    public static final String ADMIN = Constants.LOGIN_ADMIN;

    /**
     * 设置用户到session
     *
     * @param session
     * @param admin
     */
    public static void saveAdminToSession(HttpSession session, Admin admin) {
        UserUtil.deleteUserFromSession(session);
        session.setAttribute(ADMIN,admin);
    }

    /**
     * 从Session获取当前管理信息
     *
     * @param session
     * @return
     */
    public static Admin getAdminFromSession(HttpSession session) {
        Object attribute = session.getAttribute(ADMIN);
        return attribute == null ? null : (Admin) attribute;
    }

    /**
     * 从Session中删除登陆管理的信息
     *
     * @param session
     */
    public static void deleteAdminFromSession(HttpSession session) {
        session.removeAttribute(ADMIN);
    }
}
