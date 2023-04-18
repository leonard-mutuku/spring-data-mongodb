/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mongodb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author leonard
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class ApplicationProperties {
    
    private String authenticationDatabase;
    private String database;
    private Integer port;
    private String uri;
    private Long documentExpiry;
    private String documentExpiryUnit;
}
