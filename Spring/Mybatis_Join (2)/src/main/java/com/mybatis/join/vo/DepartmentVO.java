package com.mybatis.join.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DepartmentVO {

	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	
	public DepartmentVO() {}

 
}
