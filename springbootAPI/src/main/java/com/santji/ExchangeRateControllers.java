package com.santji;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santji.entity.ExchangeRate;
import com.santji.serviceimp.ExchangeRateServiceImpl;

//ExchangeRateControllers.java
@RestController
@RequestMapping("/api/exchange-rates")
public class ExchangeRateControllers {
 @Autowired
 private ExchangeRateServiceImpl exchangeRateServiceImpl;
 @GetMapping("/diff")
 public ResponseEntity<Map<String, String>> getPercentageDifference() {
     // Implement logic to retrieve exchange rates and calculate percentage difference
     List<ExchangeRate> exchangeRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(LocalDate.now().minusDays(1), LocalDate.now());
     LocalDate currentDate = LocalDate.now();
     Map<String, String> response = new HashMap<>();
     response.put("Last one day", exchangeRateServiceImpl.calculatePercentageDifference(exchangeRates).toString() + "%");

     // Repeat the process for other time periods (week, month, etc.) as needed
     // Adjust the date range accordingly for each time period
     // Last one day
     List<ExchangeRate> lastOneDayRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusDays(1), currentDate);
     response.put("Last one day", exchangeRateServiceImpl.calculatePercentageDifference(lastOneDayRates).toString() + "%");

     // Last one week
     List<ExchangeRate> lastOneWeekRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusWeeks(1), currentDate);
     response.put("Last one week", exchangeRateServiceImpl.calculatePercentageDifference(lastOneWeekRates).toString() + "%");

     // Last one month
     List<ExchangeRate> lastOneMonthRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusMonths(1), currentDate);
     response.put("Last one month", exchangeRateServiceImpl.calculatePercentageDifference(lastOneMonthRates).toString() + "%");

     // Last 3 months
     List<ExchangeRate> lastThreeMonthsRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusMonths(3), currentDate);
     response.put("Last 3 months", exchangeRateServiceImpl.calculatePercentageDifference(lastThreeMonthsRates).toString() + "%");

     // Last 6 months
     List<ExchangeRate> lastSixMonthsRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusMonths(6), currentDate);
     response.put("Last 6 months", exchangeRateServiceImpl.calculatePercentageDifference(lastSixMonthsRates).toString() + "%");

     // Last 9 months
     List<ExchangeRate> lastNineMonthsRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusMonths(9), currentDate);
     response.put("Last 9 months", exchangeRateServiceImpl.calculatePercentageDifference(lastNineMonthsRates).toString() + "%");

     // Last 12 months
     List<ExchangeRate> lastTwelveMonthsRates = exchangeRateServiceImpl.getExchangeRatesByDateRange(currentDate.minusMonths(12), currentDate);
     response.put("Last 12 months", exchangeRateServiceImpl.calculatePercentageDifference(lastTwelveMonthsRates).toString() + "%");

   
     return ResponseEntity.ok(response);
 }

 @PostMapping
 public ResponseEntity<String> addExchangeRate(@RequestBody ExchangeRate exchangeRate) {
     // Implement logic to add a new exchange rate entry
     // Return success message or handle errors
	 
	 return null;
 }

 @PutMapping("/{id}")
 public ResponseEntity<String> updateExchangeRate(@PathVariable String id, @RequestBody ExchangeRate exchangeRate) {
     // Implement logic to update an existing exchange rate entry
     // Return success message or handle errors
	 
	 return null;
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<String> deleteExchangeRate(@PathVariable String id) {
     // Implement logic to delete an existing exchange rate entry
     // Return success message or handle errors
	 
	 return null;
 }
}
