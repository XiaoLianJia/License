package com.license.util;

import org.jetbrains.annotations.NotNull;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * <p>
 *     主机地址工具
 * </p>
 * @author zhangbin
 * @date 2019-12-10
 */
public class HostAddressUtil {

    /**
     * 获取主机IPv4地址
     * @return IPv4地址
     */
    public static String getIpV4Address() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "127.0.0.1";
        }
    }

    /**
     * 获取主机MAC地址
     * @return MAC地址
     * @throws Exception 异常
     */
    @NotNull
    public static String getMacAddress() throws Exception {
        byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                stringBuilder.append("-");
            }
            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            stringBuilder.append(s.length() == 1 ? 0 + s : s);
        }
        return stringBuilder.toString().toUpperCase();
    }
}
