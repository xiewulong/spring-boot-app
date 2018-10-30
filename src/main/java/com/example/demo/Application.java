package com.example.demo;

import com.example.demo.components.I18n;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.context.config.annotation.RefreshScope;
// import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
// import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
// import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @EnableCircuitBreaker
// @EnableDiscoveryClient
// @EnableEurekaServer
@EnableFeignClients
@EnableJpaAuditing
@EnableSwagger2
// @EnableZuulProxy
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo(
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

  // @Bean
  // public AccessFilter accessFilter() {
  //   return new AccessFilter();
  // }

  // @Bean
  // @ConfigurationProperties("zuul")
  // @RefreshScope
  // public ZuulProperties zuulProperties() {
  //   return new ZuulProperties();
  // }

}
