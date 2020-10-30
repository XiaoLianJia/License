package com.license.util;

import com.license.common.CertificateParameters;
import com.license.common.KeyStoreParameters;
import org.junit.Test;

import java.util.Date;

/**
 * <p>
 *     密钥工具测试
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class KeyUtilTest {

    private final static String PRIVATE_KEY_STORE = "D://PrivateKeys.store";

    private final static String PUBLIC_CERT_STORE = "D://PublicCerts.store";

    private final static String CERTIFICATE_FILE = "D://Certificates.cer";

    @Test
    public void generateKeyStore() throws Exception {
        KeyStoreParameters param = new KeyStoreParameters();
        param.setStoreAlias("PRIVATE_KEY_STORE");
        param.setStorePath(PRIVATE_KEY_STORE);
        param.setStorePassword("XLJ9527");
        param.setAlgorithm("DSA");
        param.setKeySize(1024);
        param.setKeyPassword("XLJ9528");
        param.setValidity(1);
        param.setStartDate(DateUtil.parseDate(new Date(), "yyyy/MM/dd"));
        param.setHolder(String.format("CN=%s,OU=%s,O=%s,L=%s,ST=%s,C=%s",
                "XLJ", "XLJ", "XLJ", "Beijing", "Beijing", "CN"));
        System.out.println(KeyUtil.generateKeyStore(param));
    }

    @Test
    public void exportCertificate() throws Exception {
        CertificateParameters param = new CertificateParameters();
        param.setStoreAlias("PRIVATE_KEY_STORE");
        param.setStorePath(PRIVATE_KEY_STORE);
        param.setStorePassword("XLJ9527");
        param.setCertificateFile(CERTIFICATE_FILE);
        System.out.println(KeyUtil.exportCertificate(param));
    }

    @Test
    public void importCertificate() throws Exception {
        CertificateParameters param = new CertificateParameters();
        param.setStoreAlias("PUBLIC_CERT_STORE");
        param.setStorePath(PUBLIC_CERT_STORE);
        param.setStorePassword("XLJ9527");
        param.setCertificateFile(CERTIFICATE_FILE);
        System.out.println(KeyUtil.importCertificate(param));
    }
}
