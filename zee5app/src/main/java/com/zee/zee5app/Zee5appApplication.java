package com.zee.zee5app;

import java.util.Arrays;
import java.util.Iterator;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Zee5appApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(Zee5appApplication.class, args);
		
//		String[] beanNames =  context.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for(String string : beanNames) {
//			System.out.println(string);
//		}
		
		
	}
}
