package com.example.demo.services;

import feign.RequestLine;
import org.springframework.stereotype.Service;
// import org.springframework.cloud.netflix.feign.FeignClient;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

// @FeignClient(value = "app_name", fallback = UserServiceFallback.class)
@Service
public interface UserService {

  @RequestLine("GET /")
  String index();

  // @RequestMapping(value = "/", method = RequestMethod.GET)
  // String index();

}
