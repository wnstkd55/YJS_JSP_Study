package com.mybatis.join.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmployeeVO {
	
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private int salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;
	
    
    public EmployeeVO() {}

	

}
