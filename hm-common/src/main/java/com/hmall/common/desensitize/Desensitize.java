package com.hmall.common.desensitize;

import java.lang.annotation.*;
/**
 * @Description
 * @Author lt
 * @Data 2026/01/15 09:22
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Desensitize {

    DesensitizeType type();
}
