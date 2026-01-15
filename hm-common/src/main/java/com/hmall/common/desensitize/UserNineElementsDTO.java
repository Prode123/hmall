package com.hmall.common.desensitize;

import lombok.Data;

/**
 * @Description
 * @Author LiTong(Prode)
 * @Data 2026/01/15 09:25
 */
@Data
public class UserNineElementsDTO {

    @Desensitize(type = DesensitizeType.NAME)
    private String name;

    @Desensitize(type = DesensitizeType.ID_CARD)
    private String idCard;

    @Desensitize(type = DesensitizeType.MOBILE)
    private String mobile;

    @Desensitize(type = DesensitizeType.BANK_CARD)
    private String bankCard;

    @Desensitize(type = DesensitizeType.ACCOUNT_NO)
    private String accountNo;

    private String certType;

    @Desensitize(type = DesensitizeType.CERT_NO)
    private String certNo;

    @Desensitize(type = DesensitizeType.ADDRESS)
    private String address;

    @Desensitize(type = DesensitizeType.EMAIL)
    private String email;
}

