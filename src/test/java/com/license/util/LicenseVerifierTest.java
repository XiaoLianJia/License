package com.license.util;

import com.license.LicenseVerifier;
import org.junit.Test;

/**
 * <p>
 *     License验证器测试
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
public class LicenseVerifierTest {

    @Test
    public void install() throws Exception {
        new LicenseVerifier().install();
    }

    @Test
    public void verify() throws Exception {
        System.out.println(new LicenseVerifier().verify());
    }

    @Test
    public void install2() throws Exception {
        new LicenseVerifier("/licenseVerify.properties").install();
    }

    @Test
    public void verify2() throws Exception {
        System.out.println(new LicenseVerifier("/licenseVerify.properties").verify());
    }
}
