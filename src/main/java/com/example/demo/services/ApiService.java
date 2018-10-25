package com.example.demo.services;

import feign.Feign;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

  public UserService user() {
    return Feign.builder()
                .target(UserService.class, "http://www.baidu.com")
                ;
  }

}
