package br.com.granjainteligente.granja;

import br.com.granjainteligente.granja.Repository.BaiaRepository;
import br.com.granjainteligente.granja.model.Baia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaAuditing
public class GranjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GranjaApplication.class, args);
	}
        @Bean
        public WebMvcConfigurer corsConfigurer() {
           return new WebMvcConfigurerAdapter() {
              @Override
              public void addCorsMappings(CorsRegistry registry) {
                 registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET","POST","PUT");
              }
           };
        }
}
