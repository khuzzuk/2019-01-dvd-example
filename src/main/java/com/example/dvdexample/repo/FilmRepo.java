package com.example.dvdexample.repo;

import com.example.dvdexample.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepo extends JpaRepository<Film, Integer> {
}
