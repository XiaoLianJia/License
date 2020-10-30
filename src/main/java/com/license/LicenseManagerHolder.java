package com.license;

import de.schlichtherle.license.LicenseManager;
import de.schlichtherle.license.LicenseParam;

/**
 * <p>
 *     License管理器
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class LicenseManagerHolder {

    private static volatile LicenseManager licenseManager;

    public static LicenseManager getLicenseManager(LicenseParam param) {
        if (null == licenseManager) {
            synchronized (LicenseManagerHolder.class) {
                if (null == licenseManager) {
                    licenseManager = new LicenseManager(param);
                }
            }
        }
        return licenseManager;
    }
}
