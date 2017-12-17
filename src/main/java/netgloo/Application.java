package netgloo;

import netgloo.models.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import netgloo.services.FillApp;

/*
 * The @SpringBootApplication annotation is equivalent to using 
 * @Configuration, @EnableAutoConfiguration and @ComponentScan with their default attributes:
 */

/**
 * 
 * @author Miloš
 *
 */
@SpringBootApplication
//@EnableAutoConfiguration
@ComponentScan()
@EnableJpaRepositories
public class Application extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

  public static void main(String[] args) {
	  ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    
    try {
    	context.getBean(FillApp.class).fillImgUrls();
		context.getBean(FillApp.class).fillCarouselImg();
//		context.getBean(FillDataBase.class).fillCar();


	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Exeption during App running: " + e);
	}
  }

}
