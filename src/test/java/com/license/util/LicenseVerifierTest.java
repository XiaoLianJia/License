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

    private LicenseVerifier verifier = new LicenseVerifier();

    private LicenseVerifier verifier2 = new LicenseVerifier("/licenseVerify.properties");

    @Test
    public void install() throws Exception {
        verifier.install();
    }

    @Test
    public void verify() throws Exception {
        System.out.println(verifier.verify());
    }

    @Test
    public void install2() throws Exception {
        verifier2.install();
    }

    @Test
    public void verify2() throws Exception {
        System.out.println(verifier2.verify());
    }
}
