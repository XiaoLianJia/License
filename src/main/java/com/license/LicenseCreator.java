package com.license;

import com.license.common.KeyStoreParameters;
import com.license.common.LicenseParameters;
import com.license.util.DateUtil;
import de.schlichtherle.license.*;

import javax.security.auth.x500.X500Principal;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.Preferences;

/**
 * <p>
 *     License生成器
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class LicenseCreator {

    private KeyStoreParameters keyStoreParameters = new KeyStoreParameters();

    private LicenseParameters licenseParameters = new LicenseParameters();

    public LicenseCreator() {
        initialize("/license.properties");
    }

    public LicenseCreator(String configPath) {
        initialize(configPath);
    }

    private void initialize(String configPath) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(configPath)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        keyStoreParameters.setStoreAlias(properties.getProperty("private.keyStore.alias"));
        keyStoreParameters.setStorePath(properties.getProperty("private.keyStore.path"));
        keyStoreParameters.setStorePassword(properties.getProperty("private.keyStore.password"));
        keyStoreParameters.setKeyPassword(properties.getProperty("private.keyStore.keyPassword"));
        keyStoreParameters.setHolder(properties.getProperty("private.keyStore.holder"));

        licenseParameters.setSubject(properties.getProperty("license.subject"));
        licenseParameters.setIssuer(properties.getProperty("license.issuer"));
        licenseParameters.setIssuedTime(properties.getProperty("license.issuedTime"));
        licenseParameters.setNotBefore(properties.getProperty("license.notBefore"));
        licenseParameters.setNotAfter(properties.getProperty("license.notAfter"));
        licenseParameters.setConsumerType(properties.getProperty("license.consumerType"));
        licenseParameters.setConsumerAmount(Integer.parseInt(properties.getProperty("license.consumerAmount")));
        licenseParameters.setInfo(properties.getProperty("license.info"));
        licenseParameters.setIpAddress(properties.getProperty("license.ipAddress"));
        licenseParameters.setMacAddress(properties.getProperty("license.macAddress"));
        licenseParameters.setStorePath(properties.getProperty("license.storePath"));
    }

    public void create() throws Exception {
        Class<LicenseCreator> clazz = LicenseCreator.class;
        Preferences preferences = Preferences.userNodeForPackage(clazz);
        CipherParam cipherParam = new DefaultCipherParam(keyStoreParameters.getStorePassword());
        KeyStoreParam keyStoreParam = new DefaultKeyStoreParam(clazz,
                keyStoreParameters.getStorePath(), keyStoreParameters.getStoreAlias(),
                keyStoreParameters.getStorePassword(), keyStoreParameters.getKeyPassword());
        LicenseParam licenseParam = new DefaultLicenseParam(licenseParameters.getSubject(), preferences, keyStoreParam, cipherParam);

        Map<String, String> extra = new HashMap<>(2);
        extra.put("ip", licenseParameters.getIpAddress());
        extra.put("mac", licenseParameters.getMacAddress());

        LicenseContent licenseContent = new LicenseContent();
        licenseContent.setSubject(licenseParameters.getSubject());
        licenseContent.setHolder(new X500Principal(licenseParameters.getIssuer()));
        licenseContent.setIssuer(new X500Principal(licenseParameters.getIssuer()));
        licenseContent.setIssued(DateUtil.getDate(licenseParameters.getIssuedTime(), "yyyy-MM-dd"));
        licenseContent.setNotBefore(DateUtil.getDate(licenseParameters.getNotBefore(), "yyyy-MM-dd"));
        licenseContent.setNotAfter(DateUtil.getDate(licenseParameters.getNotAfter(), "yyyy-MM-dd"));
        licenseContent.setConsumerType(licenseParameters.getConsumerType());
        licenseContent.setConsumerAmount(licenseParameters.getConsumerAmount());
        licenseContent.setInfo(licenseParameters.getInfo());
        licenseContent.setExtra(extra);

        LicenseManager licenseManager = LicenseManagerHolder.getLicenseManager(licenseParam);
        licenseManager.store(licenseContent, new File(licenseParameters.getStorePath()));
    }
}
