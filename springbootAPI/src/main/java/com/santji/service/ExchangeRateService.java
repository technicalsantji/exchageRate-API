package com.santji.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.santji.entity.ExchangeRate;
import com.santji.repository.ExchangeRateRepository;

public interface ExchangeRateService {

	
	   
	    @Scheduled(cron = "0 0 0 * * ?") // Run daily at midnight
	    public void fetchAndStoreExchangeRates();

	    public List<ExchangeRate> getExchangeRatesByDateRange(LocalDate startDate, LocalDate endDate) ;

	    public BigDecimal calculatePercentageDifference(List<ExchangeRate> rates) ;
}
