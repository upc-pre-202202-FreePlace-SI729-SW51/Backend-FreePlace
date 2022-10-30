//Put here the entity mappers
package com.acme.freeplace.profile.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("profileMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public DriverMapper driverMapper() {
        return new DriverMapper();
    }
}
