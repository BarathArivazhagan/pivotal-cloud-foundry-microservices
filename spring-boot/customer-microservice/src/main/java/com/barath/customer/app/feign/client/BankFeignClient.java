package com.barath.customer.app.feign.client;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("bank-microservice")
public interface BankFeignClient {
	
	@RequestMapping(value="/handleTransaction",method=RequestMethod.POST)
	public String handleTranscation(@RequestBody Map<String,Object> params);

}
