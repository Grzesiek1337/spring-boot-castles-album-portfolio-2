package pl.gm.castlesmvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "pl.gm")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.gm")
public class ApplicationConfig implements WebMvcConfigurer {

}
