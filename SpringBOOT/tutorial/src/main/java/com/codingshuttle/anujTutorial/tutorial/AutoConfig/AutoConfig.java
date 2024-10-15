package com.codingshuttle.anujTutorial.tutorial.AutoConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoConfig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
