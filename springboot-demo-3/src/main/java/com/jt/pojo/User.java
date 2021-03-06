package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//Lombok插件在.java文件编译为.class文件时生效.
@Data //get/set/toString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //重写的set方法

@TableName //如果表名与类名一致,则可以省略
public class User {
	//定义主键,ID自增
	@TableId(type = IdType.AUTO)
	private Integer id;

	private String name;
	private Integer age;
	private String sex;
	

	
	
}
