package com.interceptor.configuration;

import java.util.Map;

import javax.annotation.PostConstruct;

import net.logstash.logback.encoder.org.apache.commons.lang.BooleanUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.google.gson.reflect.TypeToken;
import com.interceptor.constants.InterceptorConstants;
import com.interceptor.handler.RequestInterceptor;
import com.interceptor.utils.MappingUtils;

@Configuration
public class InterceptorHandlerConfig extends WebMvcConfigurationSupport{

	@Value("${api.key.path}")
	private String apiPathMapping;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InterceptorHandlerConfig.class);
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
		if(InterceptorConstants.API_KEY_PATH != null && BooleanUtils.isFalse(InterceptorConstants.API_KEY_PATH.isEmpty())){
	      registry.addInterceptor(getRequestInterceptor()).addPathPatterns(InterceptorConstants.API_KEY_PATH.keySet().toArray(new String[InterceptorConstants.API_KEY_PATH.keySet().size()]));
		}
	}
	
	@Bean
	public RequestInterceptor getRequestInterceptor() {
	    return new RequestInterceptor();
	}
	
	@PostConstruct
    public void apiKeysPathMapping() {
			LOGGER.info("Api path mapping {} ", apiPathMapping);
           InterceptorConstants.API_KEY_PATH = MappingUtils.fromJson(apiPathMapping,new TypeToken<Map>(){}.getType());
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        
        registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}

