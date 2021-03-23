package com.test.currencyExchage.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepositiry repository;
	
	@Autowired
	private Environment environment;

	@GetMapping("/curtrency-exchange/from/{from}/to/{to}")
	public CurrencyExchange reteriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		CurrencyExchange reponse = repository.findByFromAndTo(from, to);
		if(reponse ==null) throw new RuntimeException("Unable to find conversation");
		/*
		 * CurrencyExchange reponse = new CurrencyExchange(); reponse.setId(10L);
		 * reponse.setFrom(from); reponse.setTo(to);
		 * reponse.setConverionMultiple(BigDecimal.valueOf(50));
		 */
		String port = environment.getProperty("local.server.port");
		reponse.setEnvironment(port);
		return reponse;
	}
}
