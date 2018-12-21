package com.example.demo;

import com.example.demo.components.I18n;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.config.server.EnableConfigServer;
// import org.springframework.cloud.context.config.annotation.RefreshScope;
// import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
// import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
// import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
// import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
// import springfox.documentation.service.ApiInfo;
// import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
// import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
// import springfox.documentation.swagger.web.SwaggerResource;
// import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// import java.util.ArrayList;
// import java.util.List;

// @EnableCircuitBreaker
// @EnableConfigServer
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

  // @Value("${spring.application.route.prefix}")
  // private String ROUTE_PREFIX;

  @Value("${spring.application.swagger.enabled}")
  private boolean SWAGGER_ENABLED;

  @Bean
  public Docket apiDefault() {
    return new Docket(DocumentationType.SWAGGER_2).select()
                                                    .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
                                                    .paths(PathSelectors.any())
                                                    .build()
                                                  // .apiInfo(new ApiInfo(
                                                  //   I18n.t("app.name"),
                                                  //   I18n.t("app.description"),
                                                  //   I18n.t("app.version"),
                                                  //   "http://termsOfServiceUrl",
                                                  //   new Contact("name", "http://contact.url", "contact@email.com"),
                                                  //   "license",
                                                  //   "licenseUrl"
                                                  // ))
                                                  .enable(SWAGGER_ENABLED)
                                                  // .groupName(Docket.DEFAULT_GROUP_NAME)
                                                  // .pathMapping(ROUTE_PREFIX)
                                                  ;
  }

  // @Bean
  // public Docket apiV1() {
  //   return new Docket(DocumentationType.SWAGGER_2).select()
  //                                                   .apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
  //                                                   .paths(PathSelectors.ant("/v1/**"))
  //                                                   .build()
  //                                                 .apiInfo(new ApiInfo(
  //                                                   I18n.t("app.name"),
  //                                                   I18n.t("app.description"),
  //                                                   I18n.t("app.version"),
  //                                                   "http://termsOfServiceUrl",
  //                                                   new Contact("name", "http://contact.url", "contact@email.com"),
  //                                                   "license",
  //                                                   "licenseUrl"
  //                                                 ))
  //                                                 .endable(SWAGGER_ENABLED)
  //                                                 .groupName("v1")
  //                                                 // .pathMapping(ROUTE_PREFIX)
  //                                                 ;
  // }

  // @Bean
  // @Primary
  // public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider) {
  //   return () -> {
  //     List<SwaggerResource> swaggerResources = new ArrayList<>(inMemorySwaggerResourcesProvider.get());

  //     // SwaggerResource appV1SwaggerResource = new SwaggerResource();
  //     // appV1SwaggerResource.setName("App v1");
  //     // appV1SwaggerResource.setLocation("/app/v2/api-docs?group=v1");
  //     // appV1SwaggerResource.setSwaggerVersion("2.0");
  //     // swaggerResources.add(appV1SwaggerResource);

  //     // ...

  //     return swaggerResources;
  //   };
  // }

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
  // public PatternServiceRouteMapper patternServiceRouteMapper() {
  //   return new PatternServiceRouteMapper("(?<name>.*)-(?<version>v.*$)", "${version}/${name}");
  // }

  // @Bean
  // @ConfigurationProperties("zuul")
  // @RefreshScope
  // public ZuulProperties zuulProperties() {
  //   return new ZuulProperties();
  // }

}
