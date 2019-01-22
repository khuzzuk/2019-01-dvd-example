package com.example.dvdexample.film;

import com.example.dvdexample.model.Film;
import com.example.dvdexample.model.Inventory;
import com.example.dvdexample.model.Payment;
import com.example.dvdexample.model.Rental;
import com.example.dvdexample.repo.FilmRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@Service
public class FilmServiceImpl implements FilmService {
    private FilmRepo filmRepo;

    @Override
    @Transactional
    public Map<String, Map<Date, BigDecimal>> getProfits() {
        Map<String, Map<Date, BigDecimal>> result = new HashMap<>();
        List<Film> films = filmRepo.findAll();

        for (Film f : films) {
            Set<Inventory> inventories = f.getInventories();
            Map<Date, BigDecimal> profits = result.computeIfAbsent(f.getTitle(), s -> new HashMap<>());
            for (Inventory i : inventories) {
                Set<Rental> rentals = i.getRentals();
                for (Rental r : rentals) {
                    Set<Payment> payments = r.getPayments();
                    for (Payment p : payments) {
                        BigDecimal amount = profits
                                .computeIfAbsent(p.getPaymentDate(), __ -> BigDecimal.ZERO)
                                .add(p.getAmount());
                        profits.put(p.getPaymentDate(), amount);
                    }
                }
            }
        }
        return result;
    }
}
