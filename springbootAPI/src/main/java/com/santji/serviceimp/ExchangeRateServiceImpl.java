package com.santji.serviceimp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.santji.entity.ExchangeRate;
import com.santji.repository.ExchangeRateRepository;
import com.santji.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {
	  static List<ExchangeRate> exchangeRates = new ArrayList<>();

	    static {
	        try {
	            exchangeRates.add(new ExchangeRate("012", LocalDate.of(2023, 1, 1), new BigDecimal("1.1000")));
	            exchangeRates.add(new ExchangeRate("013", LocalDate.of(2023, 2, 1), new BigDecimal("1.1500")));
	            exchangeRates.add(new ExchangeRate("014", LocalDate.of(2023, 3, 1), new BigDecimal("1.2000")));
	            exchangeRates.add(new ExchangeRate("015", LocalDate.of(2023, 4, 1), new BigDecimal("1.1800")));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Autowired
	    private ExchangeRateRepository exchangeRateRepository;

	    @Scheduled(cron = "0 0 0 * * ?") // Run daily at midnight
	    public void fetchAndStoreExchangeRates() {
	        // Implement logic to fetch exchange rates from the external API
	        // Store the data in MongoDB using exchangeRateRepository
	    }

	    public List<ExchangeRate> getExchangeRatesByDateRange(LocalDate startDate, LocalDate endDate) {
	        // Implement logic to retrieve exchange rates within the specified date range
	    	
	    	return null;
	    }

		@Override
		public BigDecimal calculatePercentageDifference(List<ExchangeRate> res) {
			
			
			
			  if (exchangeRates == null || exchangeRates.size() < 2) {
		            throw new IllegalArgumentException("At least two exchange rates are required to calculate percentage difference");
		        }

		        // Get the first and last exchange rates
		        ExchangeRate firstRate = exchangeRates.get(0);
		        ExchangeRate lastRate = exchangeRates.get(exchangeRates.size() - 1);

		        // Calculate percentage difference
		        BigDecimal initialRate = firstRate.getRate();
		        BigDecimal finalRate = lastRate.getRate();
		        BigDecimal difference = finalRate.subtract(initialRate);

		        if (initialRate.equals(BigDecimal.ZERO)) {
		            // Avoid division by zero
		            return BigDecimal.ZERO;
		        }

		        BigDecimal percentageDifference = difference.divide(initialRate, 4, RoundingMode.HALF_UP)
		                .multiply(BigDecimal.valueOf(100));

		        return percentageDifference;
		}
}
