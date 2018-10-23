package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@ApiModel(value = "用户类", description = "用户类描述")
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_users")
public class User {

  @ApiModelProperty(value = "ID")
  @Id
  @GeneratedValue
  private Long id;

  @ApiModelProperty(value = "姓名")
  private String name;

  @ApiModelProperty(value = "年龄")
  private Integer age;

  @ApiModelProperty(value = "创建时间")
  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
  private Date created_at;

  @ApiModelProperty(value = "更新时间")
  @LastModifiedDate
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
  private Date updated_at;

}
