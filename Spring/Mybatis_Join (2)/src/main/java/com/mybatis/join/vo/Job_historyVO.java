package com.mybatis.join.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Job_historyVO {
	private int employee_id;
	private String start_date;
	private String end_date;
	private String job_id;
	private int department_id;
	
}
