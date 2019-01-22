package com.example.dvdexample.repo;

import com.example.dvdexample.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepo extends JpaRepository<Film, Integer> {
    Optional<Film> findByTitle(String title);
}
