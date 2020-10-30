package com.license.util;

import com.license.KeyStoreGenerator;
import org.junit.Test;

/**
 * <p>
 *     密钥库创建器测试
 * </p>
 * @author zhangbin
 * @date 2020-10-30
 */
public class KeyStoreGeneratorTest {

    private KeyStoreGenerator generator = new KeyStoreGenerator();

    @Test
    public void generatePrivateKeysStore() throws Exception {
        generator.generatePrivateKeysStore();
    }

    @Test
    public void generatePublicCertsStore() throws Exception {
        generator.generatePublicCertsStore();
    }
}
