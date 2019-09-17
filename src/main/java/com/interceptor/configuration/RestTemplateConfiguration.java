package com.interceptor.configuration;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean(name = { "restTemplate" })
    @Primary
    public RestTemplate restTemplate() {
        final RestTemplate restTemplate =new RestTemplate(clientHttpRequestFactory());
        return restTemplate;
    }
	  private ClientHttpRequestFactory clientHttpRequestFactory() {
	        final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	        factory.setReadTimeout(5000);
	        factory.setConnectTimeout(500);
	        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	    	cm.setMaxTotal(7200);
	    	cm.setDefaultMaxPerRoute(1200);
	    	CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
	         factory.setHttpClient(httpClient);
	         return factory;
	    }
	  
}