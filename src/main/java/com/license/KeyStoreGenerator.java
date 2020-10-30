package com.license;

import com.license.common.CertificateParameters;
import com.license.common.KeyStoreParameters;
import com.license.util.KeyUtil;

import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 *     密钥库创建器
 * </p>
 * @author zhangbin
 * @date 2020-10-30
 */
public class KeyStoreGenerator {

    private KeyStoreParameters privateKeysStore = new KeyStoreParameters();

    private KeyStoreParameters publicCertsStore = new KeyStoreParameters();

    public KeyStoreGenerator() {
        initialize("/license.properties");
    }

    public KeyStoreGenerator(String configPath) {
        initialize(configPath);
    }

    private void initialize(String configPath) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(configPath)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        privateKeysStore.setStoreAlias(properties.getProperty("private.keyStore.alias"));
        privateKeysStore.setStorePath(properties.getProperty("private.keyStore.path"));
        privateKeysStore.setStorePassword(properties.getProperty("private.keyStore.password"));
        privateKeysStore.setKeyPassword(properties.getProperty("private.keyStore.keyPassword"));
        privateKeysStore.setAlgorithm(properties.getProperty("private.keyStore.algorithm"));
        privateKeysStore.setKeySize(Integer.parseInt(properties.getProperty("private.keyStore.keySize")));
        privateKeysStore.setValidity(Integer.parseInt(properties.getProperty("private.keyStore.validity")));
        privateKeysStore.setStartDate(properties.getProperty("private.keyStore.startDate"));
        privateKeysStore.setHolder(properties.getProperty("private.keyStore.holder"));

        publicCertsStore.setStoreAlias(properties.getProperty("public.keyStore.alias"));
        publicCertsStore.setStorePath(properties.getProperty("public.keyStore.path"));
        publicCertsStore.setStorePassword(properties.getProperty("public.keyStore.password"));
    }

    public void generatePrivateKeysStore() throws Exception {
        KeyUtil.generateKeyStore(privateKeysStore);
    }

    public void generatePublicCertsStore() throws Exception {
        CertificateParameters param = new CertificateParameters();
        param.setStoreAlias(privateKeysStore.getStoreAlias());
        param.setStorePath(privateKeysStore.getStorePath());
        param.setStorePassword(privateKeysStore.getStorePassword());
        param.setCertificateFile("/Certificates.cer");
        KeyUtil.exportCertificate(param);

        param.setStoreAlias(publicCertsStore.getStoreAlias());
        param.setStorePath(publicCertsStore.getStorePath());
        param.setStorePassword(publicCertsStore.getStorePassword());
        KeyUtil.importCertificate(param);
    }
}
