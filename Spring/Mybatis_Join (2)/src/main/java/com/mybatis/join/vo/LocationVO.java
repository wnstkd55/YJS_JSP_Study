package com.mybatis.join.vo;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class LocationVO {
	private int location_id;
	private String street_address;
	private int postal_code;
	private String city;
	private String state_province;
	private String country_id;
}
