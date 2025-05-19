package com.ark.poc.configs.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.security.user")
@Data
public class UserProperties {

    private String name;
    private String password;

}
