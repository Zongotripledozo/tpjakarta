package org.efrei.start.controllers;

import org.efrei.start.models.Movie;
import org.efrei.start.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService filmService;

    @GetMapping
    public List<Movie> getAllFilms() {
        return filmService.getAllMovies();
    }

    @GetMapping("/{identifier}")
    public Movie getFilmById(@PathVariable Long identifier) {
        return filmService.getMovieById(identifier);
    }

    @PostMapping
    public Movie createFilm(@RequestBody Movie film) {
        return filmService.saveMovie(film);
    }

    @PutMapping("/{identifier}")
    public Movie updateFilm(@PathVariable Long identifier, @RequestBody Movie filmDetails) {
        Movie film = filmService.getMovieById(identifier);
        if (film != null) {
            film.setTitle(filmDetails.getTitle());
            film.setDirector(filmDetails.getDirector());
            film.setActors(filmDetails.getActors());
            film.setGenres(filmDetails.getGenres());
            return filmService.saveMovie(film);
        }
        return null;
    }

    @DeleteMapping("/{identifier}")
    public void deleteFilm(@PathVariable Long identifier) {
        filmService.deleteMovie(identifier);
    }
}
