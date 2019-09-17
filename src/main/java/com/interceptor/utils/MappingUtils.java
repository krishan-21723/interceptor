package com.interceptor.utils;

import java.lang.reflect.Type;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Component
public class MappingUtils {

	private static Gson GSON_DATE_FORMATTED = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	
	public static <T> T fromJson(String s, Type typeOfT) {
		if (StringUtils.isBlank(s))
			return null;
		return GSON_DATE_FORMATTED.fromJson(s, typeOfT);
	}
}
