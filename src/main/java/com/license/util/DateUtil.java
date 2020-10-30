package com.license.util;

import org.jetbrains.annotations.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     日期工具类
 * </p>
 * @author zhangbin
 * @date 2020-09-29
 */
public class DateUtil {

    public final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Nullable
    public static Date getDate(String dateString, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static Date parseString(String dateString, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static String parseDate(Date date, String format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static String parseLong(Long dateLong, String format) {
        try {
            Date date = new Date(dateLong);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }
}
