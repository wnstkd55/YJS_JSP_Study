package com.mybatis.join.vo;

import lombok.Data;

@Data
public class JoinVO2 {
	
	private EmployeeVO empJ; 
	private DepartmentVO deptJ;
	private Job_historyVO jobhJ;
	private LocationVO locJ;
	
	public JoinVO2 () {}

	public JoinVO2(EmployeeVO empJ, DepartmentVO deptJ, Job_historyVO jobhJ, LocationVO locJ) {
		super();
		this.empJ = empJ;
		this.deptJ = deptJ;
		this.jobhJ = jobhJ;
		this.locJ = locJ;
	}
	
	
	
}
