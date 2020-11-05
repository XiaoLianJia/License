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

    @Test
    public void generatePrivateKeysStore() throws Exception {
        new KeyStoreGenerator().generatePrivateKeysStore();
    }

    @Test
    public void generatePublicCertsStore() throws Exception {
        new KeyStoreGenerator().generatePublicCertsStore();
    }

    @Test
    public void generatePrivateKeysStore2() throws Exception {
        new KeyStoreGenerator("/keyStoreGenerate.properties").generatePrivateKeysStore();
    }

    @Test
    public void generatePublicCertsStore2() throws Exception {
        new KeyStoreGenerator("/keyStoreGenerate.properties").generatePublicCertsStore();
    }
}
