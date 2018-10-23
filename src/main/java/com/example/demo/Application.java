package com.example.demo;

import com.example.demo.components.I18n;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @EnableEurekaServer
@EnableJpaAuditing
@EnableSwagger2
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(new ApiInfo(
                    I18n.t("app.name"),
                    I18n.t("app.description"),
                    I18n.t("app.version"),
                    "http://termsOfServiceUrl",
                    new Contact("name", "http://contact.url", "contact@email.com"),
                    "license",
                    "licenseUrl"
            ))
            .select()
              .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
              .build()
            ;
  }

  @Bean
  public LocalValidatorFactoryBean validator() {
    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    localValidatorFactoryBean.setValidationMessageSource(I18n.getMessageSource());

    return localValidatorFactoryBean;
  }

}
