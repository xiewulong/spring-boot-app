package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class UserServiceFallback implements UserService {

  @Override
  public String index() {
    return "error";
  }

}
