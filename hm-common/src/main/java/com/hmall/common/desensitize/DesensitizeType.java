package com.hmall.common.desensitize;

/**
 * @Description
 * @Author lt
 * @Data 2026/01/15 09:21
 */

public enum DesensitizeType {
    /** 姓名 */
    NAME,

    /** 身份证号 */
    ID_CARD,

    /** 手机号 */
    MOBILE,

    /** 银行卡号 */
    BANK_CARD,

    /** 账户号（对公 / 对私） */
    ACCOUNT_NO,

    /** 证件类型（一般不脱敏，预留） */
    CERT_TYPE,

    /** 证件号码（护照、军官证等） */
    CERT_NO,

    /** 地址 */
    ADDRESS,

    /** 邮箱 */
    EMAIL
}
