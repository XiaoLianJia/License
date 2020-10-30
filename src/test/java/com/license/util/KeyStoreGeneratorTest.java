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

    private KeyStoreGenerator generator2 = new KeyStoreGenerator("/keyStoreGenerate.properties");

    @Test
    public void generatePrivateKeysStore() throws Exception {
        generator.generatePrivateKeysStore();
    }

    @Test
    public void generatePublicCertsStore() throws Exception {
        generator.generatePublicCertsStore();
    }

    @Test
    public void generatePrivateKeysStore2() throws Exception {
        generator2.generatePrivateKeysStore();
    }

    @Test
    public void generatePublicCertsStore2() throws Exception {
        generator2.generatePublicCertsStore();
    }
}
