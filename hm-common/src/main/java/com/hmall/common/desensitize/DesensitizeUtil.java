package com.hmall.common.desensitize;

/**
 * @Description
 * @Author LiTong(Prode)
 * @Data 2026/01/15 09:23
 */
public class DesensitizeUtil {
    private DesensitizeUtil() {}

    public static String desensitize(String value, DesensitizeType type) {
        if (value == null || value.isEmpty()) {
            return value;
        }

        switch (type) {
            case NAME:
                return desensitizeName(value);
            case MOBILE:
                return desensitizeMobile(value);
            case ID_CARD:
                return desensitizeIdCard(value);
            case BANK_CARD:
                return desensitizeBankCard(value);
            case ACCOUNT_NO:
                return desensitizeAccountNo(value);
            case CERT_NO:
                return desensitizeCertNo(value);
            case ADDRESS:
                return desensitizeAddress(value);
            case EMAIL:
                return desensitizeEmail(value);
            case CERT_TYPE:
            default:
                // 证件类型通常不脱敏
                return value;
        }
    }

    /** 姓名：张三 → 张* */
    private static String desensitizeName(String name) {
        if (name.length() <= 1) {
            return "*";
        }
        return name.charAt(0) + repeat("*", name.length() - 1);
    }

    /** 手机号：13812345678 → 138****5678 */
    private static String desensitizeMobile(String mobile) {
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /** 身份证：前6后4 */
    private static String desensitizeIdCard(String idCard) {
        return idCard.replaceAll("(\\w{6})\\w+(\\w{4})", "$1********$2");
    }

    /** 银行卡：前4后4 */
    private static String desensitizeBankCard(String cardNo) {
        return cardNo.replaceAll("(\\d{4})\\d+(\\d{4})", "$1****$2");
    }

    /** 账户号：前3后3 */
    private static String desensitizeAccountNo(String accNo) {
        if (accNo.length() <= 6) {
            return "****";
        }
        return accNo.substring(0, 3)
                + repeat("*", accNo.length() - 6)
                + accNo.substring(accNo.length() - 3);
    }

    /** 证件号：通用规则 */
    private static String desensitizeCertNo(String certNo) {
        if (certNo.length() <= 4) {
            return "****";
        }
        return certNo.substring(0, 2)
                + repeat("*", certNo.length() - 4)
                + certNo.substring(certNo.length() - 2);
    }

    /** 地址：保留前6位 */
    private static String desensitizeAddress(String address) {
        if (address.length() <= 6) {
            return address + "****";
        }
        return address.substring(0, 6) + "****";
    }

    /** 邮箱：a***@xx.com */
    private static String desensitizeEmail(String email) {
        int idx = email.indexOf("@");
        if (idx <= 1) {
            return "*@" + email.substring(idx + 1);
        }
        return email.charAt(0) + "***" + email.substring(idx);
    }

    /**
     * @Description  jdk11可以使用repeat方法
     * @Author LiTong(Prode)
     * @Date 2026/01/15 14:19
     **/
    private static String repeat(String str, int count) {
        return String.valueOf(str).repeat(Math.max(0, count));
    }
    /**
     * @Description  jdk8使用以下方法
     * @Author LiTong(Prode)
     * @Date 2026/01/15 14:20
     **/
//    public static String repeat(String str, int count) {
//        if (str == null || count <= 0) {
//            return "";
//        }
//        StringBuilder sb = new StringBuilder(str.length() * count);
//        for (int i = 0; i < count; i++) {
//            sb.append(str);
//        }
//        return sb.toString();
//    }
}
