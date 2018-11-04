package com.example.demo.controllers;

import com.example.demo.components.I18n;
import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(description = "主页")
@RequestMapping("${spring.application.route.prefix}/home")
@RestController
public class HomeController {

  @ApiOperation(value = "首页")
//  @ApiImplicitParams({
//          @ApiImplicitParam(name = "param", value = "参数名", paramType = "query", required = true, defaultValue = ""),
//  })
  @RequestMapping(value = "", method = RequestMethod.GET)
  public String index() {
    return I18n.t("app.name");
  }

}
