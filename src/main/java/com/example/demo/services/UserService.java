package com.example.demo.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "app2", fallback = UserServiceFallback.class)
public interface UserService {

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  String index();

}
