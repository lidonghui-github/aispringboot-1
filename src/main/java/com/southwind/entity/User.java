package com.southwind.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class User {
    @NotNull(message = "id不不能为空")
    private Long id;
    @NotEmpty(message = "姓名不不能为空")
    @Length(min = 2,message = "姓名⻓长度不不能⼩小于2位")
    private String name;
    @Min(value = 16,message = "年年龄必须⼤大于16岁")
    private int age;
}
