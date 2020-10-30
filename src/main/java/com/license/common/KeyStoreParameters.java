package com.license.common;

import lombok.Data;

/**
 * <p>
 *     密钥库参数
 * </p>
 * @author zhangbin
 * @date 2020-10-29
 */
@Data
public class KeyStoreParameters {

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
     * 密钥算法。
     */
    private String algorithm;

    /**
     * 密钥长度。
     */
    private int keySize;

    /**
     * 密钥口令。
     */
    private String keyPassword;

    /**
     * 有效天数。
     */
    private int validity;

    /**
     * 有效期开始日期/时间。
     */
    private String startDate;

    /**
     * 创建者，
     * CN={名字与姓氏},OU={组织单位名称},O={组织名称},L={城市或区域名称},ST={省/市/自治区名称},C={国家/地区代码}。
     */
    private String holder;
}
