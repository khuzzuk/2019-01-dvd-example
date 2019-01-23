package com.example.dvdexample.film;

import com.example.dvdexample.model.*;
import com.example.dvdexample.repo.FilmRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@Service
public class FilmServiceImpl implements FilmService {
    private FilmRepo filmRepo;
    private EntityManager entityManager;

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

    @Override
    public List<Profit> calculateProfits() {
        TypedQuery<Profit> query = entityManager.createQuery("" +
                "SELECT new com.example.dvdexample.model.Profit(f.title, p.paymentDate, SUM(p.amount)) " +
                "FROM Film f " +
                "   JOIN f.inventories i " +
                "   JOIN i.rentals r " +
                "   JOIN r.payments p " +
                "GROUP BY f, p.paymentDate", Profit.class);

        return query.getResultList();
    }
}
