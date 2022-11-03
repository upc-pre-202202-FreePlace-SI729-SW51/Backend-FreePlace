package com.acme.freeplace.security.register.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("registerMappingConfiguration")
public class MappingConfiguration {

    @Bean BusinessMapper businessMapper(){
        return new BusinessMapper();
    }
}
