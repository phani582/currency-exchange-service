package com.test.currencyExchage.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
	@CircuitBreaker(name="default", fallbackMethod = "hardCodedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name = "default")
	public String sampleAPi() {
		logger.info("Sample api recieved:: ");
		new RestTemplate().getForEntity("http://localhost:7889", String.class);
		return "Sample API";
	}
	
	
	public String hardCodedResponse(Exception e) {
		logger.info("fall back response:: "+ e.getMessage());
		return "fallback response";
	}

}
