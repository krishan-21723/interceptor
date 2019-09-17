package com.interceptor.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ABExperiment {

	private String customerId;
	private String cityId;
	private String apiPath;
	private String requestParams;
	private String expId;
	private String apiVariantEnum;
	private String apiType;
	
	
}
