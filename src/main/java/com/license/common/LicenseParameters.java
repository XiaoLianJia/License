package com.license.common;

import lombok.Data;

/**
 * <p>
 *     License参数
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
@Data
public class LicenseParameters {

    /**
     * 证书授权项目。
     */
    private String subject;

    /**
     * 发布者。
     */
    private String issuer;

    /**
     * 发布日期。
     */
    private String issuedTime;

    /**
     * 生效日期。
     */
    private String notBefore;

    /**
     * 失效日期。
     */
    private String notAfter;

    /**
     * 使用者类型（用户：user，电脑：computer，其他：else）。
     */
    private String consumerType;

    /**
     * 使用者数量。
     */
    private int consumerAmount;

    /**
     * 证书说明。
     */
    private String info;

    /**
     * IP地址。
     */
    private String ipAddress;

    /**
     * MAC地址。
     */
    private String macAddress;

    /**
     * 证书存储路径。
     */
    private String storePath;
}
