package com.redis.Redis_Implementation_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisImplementationProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedisImplementationProjectApplication.class, args);
	}

}
