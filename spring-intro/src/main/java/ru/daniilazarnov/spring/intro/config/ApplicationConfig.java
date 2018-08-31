package ru.daniilazarnov.spring.intro.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ConfigurationProperties("application")
public class ApplicationConfig {

    private String baseMessagePath;

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(baseMessagePath);
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }

    public void setBaseMessagePath(String baseMessagePath) {
        this.baseMessagePath = baseMessagePath;
    }

}
