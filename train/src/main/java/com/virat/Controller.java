package com.virat;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
	
	@GetMapping("/")
	@ResponseBody public String hello() {
		return "hello";
	}
	
	@GetMapping(path="trains")
	@ResponseBody public List<Object> getTrainData() {
		String url = "http://104.211.219.98/train/trains";
		RestTemplate rt = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();        
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
		messageConverters.add(converter);  
		r.setMessageConverters(messageConverters); 
		Object[] train = rt.getForObject(url, Object[].class);
		return Arrays.asList(train);
	}

}
