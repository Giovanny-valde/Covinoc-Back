package com.covinoc.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanMapper {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
