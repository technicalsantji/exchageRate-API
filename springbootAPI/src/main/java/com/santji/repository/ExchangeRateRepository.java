package com.santji.repository;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santji.entity.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends MongoRepository<ExchangeRate, String>{

 Optional<ExchangeRate>	findByDate(LocalDate localDate);
}
