package com.atguigu.gmall.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GmallSearchWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmallSearchWebApplication.class, args);
	}

}
