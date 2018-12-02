package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "cors")
@Data
public class CorsConfig {

    private String allowedOrigins = "*";
//    private String allowedMethods = "*";
//    private boolean allowCredentials = true;
//    private long maxAge = 1800;
}
