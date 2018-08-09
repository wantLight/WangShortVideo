package com.imooc;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
@ComponentScan(basePackages = {"com.imooc","org.n3r.idworker"})
public class ImoocVideosDevServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImoocVideosDevServiceApplication.class, args);
	}
}
