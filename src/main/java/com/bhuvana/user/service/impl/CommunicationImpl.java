package com.bhuvana.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component("communication")
public class CommunicationImpl implements CommunicationService{

    @Autowired
    WebClient webClient;

	@Autowired
	private RestTemplate restTemplate ;

	public String getDepartmentDetails() {
		// TODO Auto-generated method stub
		System.out.println("====communication Impl----");

//		String resp = restTemplate.getForObject("http://DEPARTMENT-SERVICE/api/department/test", String.class);

		String resp = restTemplate.getForObject("http://localhost:8082/api/department/test", String.class);

		return resp;
	}

	public String getDepartmentDetailsByWebClient() {
		// TODO Auto-generated method stub

        String resp  = webClient.get()
                 .uri("http://DEPARTMENT-SERVICE/api/department/test")
                         .retrieve()
                                 .bodyToMono(String.class)
                                         .block();
		return resp;
	}
}
