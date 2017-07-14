 package com.niit.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@EnableWebMvc //<mvc:annotation-driven>
@ComponentScan(basePackages="com.niit.*") //<context:component-scan>
public class WebConfig extends WebMvcConfigurerAdapter
{
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/WEB-INF/resources/");
	}
}
