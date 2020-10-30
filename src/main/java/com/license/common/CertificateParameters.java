package com.license.common;

import lombok.Data;

/**
 * <p>
 *     证书参数
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
@Data
public class CertificateParameters {

    /**
     * 密钥库别名。
     */
    private String storeAlias;

    /**
     * 密钥库路径。
     */
    private String storePath;

    /**
     * 密钥库口令。
     */
    private String storePassword;

    /**
     * 证书路径。
     */
    private String certificateFile;
}
