package com.ark.poc.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.security.jwt")
@Data
public class JwtProperties {

    private String secretKey;
    private long expirationTime;
    private RefreshTokenProperties refreshToken;

    @Data
    public static class RefreshTokenProperties {

        private long expirationTime;

    }

}
