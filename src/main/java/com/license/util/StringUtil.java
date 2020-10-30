package com.license.util;

/**
 * <p>
 *     字符串工具
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class StringUtil {

    public static boolean isBlank(String s) {
        return null == s
                || s.trim().isEmpty();
    }

    public static boolean isNotBlank(String s) {
        return null != s
                && !s.trim().isEmpty();
    }
}
