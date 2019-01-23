package com.example.dvdexample;

import com.example.dvdexample.film.FilmService;
import com.example.dvdexample.model.Film;
import com.example.dvdexample.model.Profit;
import com.example.dvdexample.repo.FilmRepo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DvdExampleApplicationTests {
	@Autowired
	private FilmService filmService;
	@Autowired
	private FilmRepo filmRepo;

	@Test
	public void testGetProfits() {
		Map<String, Map<Date, BigDecimal>> profits = filmService.getProfits();
		Assertions.assertThat(profits).hasSize(1000);
	}

	@Test
	public void testCalculateProfits() {
		List<Profit> profits = filmService.calculateProfits();
		Assertions.assertThat(profits).hasSize(14582);
	}

	@Test
	public void testL2Cache() {
		Film byId1 = filmRepo.findById(1).get();
		Film byId2 = filmRepo.findById(1).get();
		Film byId3 = filmRepo.findById(1).get();
	}
}

