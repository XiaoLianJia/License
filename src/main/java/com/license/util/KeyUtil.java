package com.license.util;

import com.license.common.CertificateParameters;
import com.license.common.KeyStoreParameters;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 *     密钥工具
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class KeyUtil {

    @NotNull
    @Contract("null -> fail")
    public static String generateKeyStore(KeyStoreParameters param) throws Exception {
        if (null == param) {
            throw new Exception("");
        }
        if (StringUtil.isBlank(param.getKeyPassword())) {
            throw new Exception("");
        }
        if (StringUtil.isBlank(param.getStorePassword())) {
            throw new Exception("");
        }

        StringBuilder command = new StringBuilder();
        command.append("keytool -genkey");
        command.append(String.format(" -alias %s", param.getStoreAlias()));
        if (StringUtil.isNotBlank(param.getAlgorithm())) {
            command.append(String.format(" -keyalg %s", param.getAlgorithm()));
        }
        command.append(String.format(" -keysize %s", param.getKeySize()));
        command.append(String.format(" -keypass %s", param.getKeyPassword()));
        command.append(String.format(" -keystore %s", param.getStorePath()));
        command.append(String.format(" -storepass %s", param.getStorePassword()));
        command.append(String.format(" -validity %s", param.getValidity()));
        if (StringUtil.isNotBlank(param.getStartDate())) {
            command.append(String.format(" -startdate %s", param.getStartDate()));
        }
        command.append(String.format(" -dname %s", param.getHolder()));
        return CommandLineUtil.execute(command.toString()).toString();
    }

    @NotNull
    @Contract("null -> fail")
    public static String exportCertificate(CertificateParameters param) throws Exception {
        if (null == param) {
            throw new Exception("");
        }
        if (StringUtil.isBlank(param.getStorePassword())) {
            throw new Exception("");
        }

        String command = "keytool -export" +
                String.format(" -alias %s", param.getStoreAlias()) +
                String.format(" -file %s", param.getCertificateFile()) +
                String.format(" -keystore %s", param.getStorePath()) +
                String.format(" -storepass %s", param.getStorePassword());
        return CommandLineUtil.execute(command).toString();
    }

    @NotNull
    @Contract("null -> fail")
    public static String importCertificate(CertificateParameters param) throws Exception {
        if (null == param) {
            throw new Exception("");
        }
        if (StringUtil.isBlank(param.getStorePassword())) {
            throw new Exception("");
        }

        String command = "keytool -import" +
                String.format(" -alias %s", param.getStoreAlias()) +
                String.format(" -file %s", param.getCertificateFile()) +
                String.format(" -keystore %s", param.getStorePath()) +
                String.format(" -storepass %s", param.getStorePassword());
        return CommandLineUtil.execute(command, "y").toString();
    }
}
