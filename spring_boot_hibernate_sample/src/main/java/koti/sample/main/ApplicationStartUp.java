package koti.sample.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"koti.sample"})
public class ApplicationStartUp extends SpringBootServletInitializer  {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationStartUp.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationStartUp.class, args);
	}
}
