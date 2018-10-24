package com.example.demo.controllers;

import com.example.demo.forms.UserCreateForm;
import com.example.demo.models.User;
import com.example.demo.models.UserRepository;
// import com.example.demo.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户")
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  // @Autowired
  // private UserService userService;

  @ApiOperation(value = "用户列表")
  @RequestMapping(method = RequestMethod.GET)
  public Iterable<User> index() {
    return userRepository.findAll();
    // return userService.index();
  }

  @ApiOperation(value = "创建用户")
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public User create(@Validated @RequestBody UserCreateForm userCreateForm) {
    User user = new User();
    BeanUtils.copyProperties(userCreateForm, user);
    userRepository.save(user);

    return user;
  }

}
