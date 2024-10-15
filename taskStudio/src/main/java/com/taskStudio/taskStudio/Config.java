package com.taskStudio.taskStudio;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ModelMapper getmodel(){
        return new ModelMapper();
    }
}
