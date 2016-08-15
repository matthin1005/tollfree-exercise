package com.example.tollfreeproject.web;



//import org.springframework.boot.web.servlet.ServletRegistrationBean;


import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Register console for viewing data in the h2 db. 
//http://localhost:8080/console  JDBC URL:  jdbc:h2:mem:testdb

@Configuration
public class WebConfiguration {
  @Bean
  ServletRegistrationBean h2servletRegistration(){
      ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
      registrationBean.addUrlMappings("/console/*");
      return registrationBean;
  }
}