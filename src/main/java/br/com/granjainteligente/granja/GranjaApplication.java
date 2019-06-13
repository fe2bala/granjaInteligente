package br.com.granjainteligente.granja;

import br.com.granjainteligente.granja.Service.AguaService;
import br.com.granjainteligente.granja.Service.AlimentoService;
import br.com.granjainteligente.granja.Service.BaiaService;
import br.com.granjainteligente.granja.Service.SensorService;
import br.com.granjainteligente.granja.Service.TemperaturaService;
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
        @Bean
        public BaiaService baiaService() {
            return new BaiaService();
        }
        @Bean
        public AguaService aguaService() {
            return new AguaService();
        }
        @Bean
        public AlimentoService alimentoService() {
            return new AlimentoService();
        }
        @Bean
        public TemperaturaService temperaturaService() {
            return new TemperaturaService();
        }  
        @Bean
        public SensorService sensorService() {
            return new SensorService();
        }
}
