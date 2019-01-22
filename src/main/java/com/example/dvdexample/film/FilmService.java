package com.example.dvdexample.film;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FilmService {
    Map<String, Map<Date, BigDecimal>> getProfits();
}
