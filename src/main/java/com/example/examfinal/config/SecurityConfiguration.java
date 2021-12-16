package com.example.examfinal.config;

import com.example.examfinal.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends GlobalMethodSecurityConfiguration {

//  @Autowired
//  private ProjectMethodSecurityExpressionHandler projectMethodSecurityExpressionHandler;
//
//  @Override
//  protected MethodSecurityExpressionHandler createExpressionHandler() {
//    return projectMethodSecurityExpressionHandler;
//  }
//
//  @Bean
//  public ProjectMethodSecurityExpressionHandler createExpressionHandler(CityService cityService) {
//    return new ProjectMethodSecurityExpressionHandler(cityService);
//  }

}

