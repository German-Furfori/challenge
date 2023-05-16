package com.paygoal.app.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.paygoal.app.configurations" +
        "com.paygoal.app.services" +
        "com.paygoal.app.mappers" +
        "com.paygoal.app.repositories" +
        "com.paygoal.app.utils" })
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
