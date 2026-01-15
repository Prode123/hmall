package com.hmall.common.desensitize;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author LiTong(Prode)
 * @Data 2026/01/15 09:25
 */

@Configuration
public class JacksonDesensitizeConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer desensitizeCustomizer() {
        return builder -> builder.serializerByType(
                String.class, new DesensitizeSerializer()
        );
    }
}
