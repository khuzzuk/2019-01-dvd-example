package com.example.dvdexample.film;

import com.example.dvdexample.model.Profit;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FilmService {
    Map<String, Map<Date, BigDecimal>> getProfits();

    List<Profit> calculateProfits();
}
