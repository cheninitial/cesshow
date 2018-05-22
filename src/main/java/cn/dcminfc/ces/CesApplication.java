package cn.dcminfc.ces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CesApplication {
	public static void main(String[] args) {
		SpringApplication.run(CesApplication.class, args);
	}
}
