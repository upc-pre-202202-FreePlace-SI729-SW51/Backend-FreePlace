//This class is not modified.
package com.acme.freeplace.shared.mapping;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper(){
        return new EnhancedModelMapper();
    }
}
