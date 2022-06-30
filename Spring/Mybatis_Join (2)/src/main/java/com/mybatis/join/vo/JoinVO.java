package com.mybatis.join.vo;

import lombok.Data;

@Data
public class JoinVO {
	
	private EmployeeVO empJ; 
	private DepartmentVO deptJ;
	
	public JoinVO () {}
	
	public JoinVO(EmployeeVO empJ, DepartmentVO deptJ) {
		super();
		this.empJ = empJ;
		this.deptJ = deptJ;
	}
	
}
