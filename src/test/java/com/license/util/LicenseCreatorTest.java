package com.license.util;

import com.license.LicenseCreator;
import org.junit.Test;

/**
 * <P>
 *     License生成器测试
 * </P>
 * @author zhangbin
 * @date 2020-10-29
 */
public class LicenseCreatorTest {

    @Test
    public void create() throws Exception {
        LicenseCreator creator = new LicenseCreator();
        creator.create();
    }

    @Test
    public void create2() throws Exception {
        LicenseCreator creator = new LicenseCreator("/licenseCreate.properties");
        creator.create();
    }
}
