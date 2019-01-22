package com.example.dvdexample;

import com.example.dvdexample.film.FilmService;
import com.example.dvdexample.repo.FilmRepo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DvdExampleApplicationTests {
	@Autowired
	private FilmService filmService;

	@Test
	public void contextLoads() {
		Map<String, Map<Date, BigDecimal>> profits = filmService.getProfits();
		Assertions.assertThat(profits).hasSize(1000);
	}

}

