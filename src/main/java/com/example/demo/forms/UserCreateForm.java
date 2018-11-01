package com.example.demo.forms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel(value = "创建用户", description = "创建用户描述")
@Data
public class UserCreateForm {

  @ApiModelProperty(value = "姓名", example = "C")
  @NotNull
  private String name;

  @ApiModelProperty(value = "年龄", example = "20")
  @Max(value = 100)
  @Min(value = 1)
  private int age;

}
