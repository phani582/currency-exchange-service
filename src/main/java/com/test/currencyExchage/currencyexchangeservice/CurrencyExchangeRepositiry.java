package com.test.currencyExchage.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepositiry extends JpaRepository<CurrencyExchange, Long>{
	public CurrencyExchange findByFromAndTo(String from, String to);
}
