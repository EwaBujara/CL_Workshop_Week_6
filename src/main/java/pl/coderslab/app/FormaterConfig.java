package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.converter.LocalDateConverter;
import pl.coderslab.converter.MeowConverter;
import pl.coderslab.converter.UserConverter;

@Configuration
@ComponentScan("pl.coderslab")
@EnableWebMvc
@EnableTransactionManagement
public class FormaterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getMeowConverter());
        registry.addConverter(getUserConverter());
        registry.addConverter(getLocalDateConverter());
    }

    @Bean
    public MeowConverter getMeowConverter(){ return new MeowConverter(); }
    @Bean
    public UserConverter getUserConverter(){return  new UserConverter(); }
    @Bean
    public LocalDateConverter getLocalDateConverter(){return new  LocalDateConverter();}
}

