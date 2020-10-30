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

    @Test
    public void install() throws Exception {
        verifier.install();
    }

    @Test
    public void verify() throws Exception {
        System.out.println(verifier.verify());
    }
}
