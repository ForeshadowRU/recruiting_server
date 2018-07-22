package edu.omsu.jesper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "edu.omsu.jesper.controller")
public class WebConfig implements WebMvcConfigurer {

}

