package com.barath.customer.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.barath.customer.app.feign.client.BankFeignClient;

@RestController
public class ApplicationController {
	

	private final BankFeignClient bankClient;


	public ApplicationController(BankFeignClient bankClient) {
		this.bankClient = bankClient;
	}

	@RequestMapping(value="/makeTransaction",method=RequestMethod.POST)
	@ResponseBody
	public Object addMoneyToAccount(@RequestBody Map<String,Object> params){
		System.out.println("Request Params "+params);
		String result=bankClient.handleTranscation(params);
		System.out.println("Result "+result);
		return result; 
	}
	
	@RequestMapping(value="/makeFalseTransaction",method=RequestMethod.POST)
	@ResponseBody
	public Object makeFalseTransaction(@RequestBody Map<String,Object> params){
		System.out.println("Request Params "+params);
		String result=bankClient.handleTranscation(params);
		System.out.println("Result "+result);
		return result; 
	}

}
