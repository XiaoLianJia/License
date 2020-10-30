package com.license;

import com.license.common.KeyStoreParameters;
import com.license.common.LicenseParameters;
import com.license.util.HostAddressUtil;
import de.schlichtherle.license.*;

import java.io.File;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.Preferences;

/**
 * <p>
 *     License验证器
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class LicenseVerifier {

    private KeyStoreParameters keyStoreParameters = new KeyStoreParameters();

    private LicenseParameters licenseParameters = new LicenseParameters();

    public LicenseVerifier() {
        initialize("/license.properties");
    }

    public LicenseVerifier(String configPath) {
        initialize(configPath);
    }

    private void initialize(String configPath) {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream(configPath)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        keyStoreParameters.setStoreAlias(properties.getProperty("public.keyStore.alias"));
        keyStoreParameters.setStorePath(properties.getProperty("public.keyStore.path"));
        keyStoreParameters.setStorePassword(properties.getProperty("public.keyStore.password"));

        licenseParameters.setSubject(properties.getProperty("license.subject"));
        licenseParameters.setStorePath(properties.getProperty("license.storePath"));
    }

    public void install() throws Exception {
        getLicenseManager().install(new File(licenseParameters.getStorePath()));
    }

    public boolean verify() throws Exception {
        LicenseContent licenseContent = getLicenseManager().verify();
        Map<String, String> extra = (Map<String, String>) licenseContent.getExtra();
        String ipAddress = extra.get("ip");
        String macAddress = extra.get("mac");
        return HostAddressUtil.getIpV4Address().equalsIgnoreCase(ipAddress)
                && HostAddressUtil.getMacAddress().equalsIgnoreCase(macAddress);
    }

    private LicenseManager getLicenseManager() {
        Class<LicenseVerifier> clazz = LicenseVerifier.class;
        Preferences preferences = Preferences.userNodeForPackage(clazz);
        CipherParam cipherParam = new DefaultCipherParam(keyStoreParameters.getStorePassword());
        KeyStoreParam keyStoreParam = new DefaultKeyStoreParam(clazz,
                keyStoreParameters.getStorePath(), keyStoreParameters.getStoreAlias(),
                keyStoreParameters.getStorePassword(), null);
        LicenseParam licenseParam = new DefaultLicenseParam(licenseParameters.getSubject(), preferences, keyStoreParam, cipherParam);
        return LicenseManagerHolder.getLicenseManager(licenseParam);
    }
}
