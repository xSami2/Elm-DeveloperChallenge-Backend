package com.elm.developerChallenge.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;


@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@Component
public class CORS implements WebMvcConfigurer {

    private final String[] allowedMethodCORS = new String[] {"GET", "POST", "PUT", "DELETE"};


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods(allowedMethodCORS);
    }
}