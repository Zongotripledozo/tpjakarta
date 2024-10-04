package org.efrei.start.controllers;

import org.efrei.start.models.Genre;
import org.efrei.start.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService categoryService;

    @GetMapping
    public List<Genre> getAllCategories() {
        return categoryService.getAllGenres();
    }

    @GetMapping("/{identifier}")
    public Genre getCategoryById(@PathVariable Long identifier) {
        return categoryService.getGenreById(identifier);
    }

    @PostMapping
    public Genre createCategory(@RequestBody Genre category) {
        return categoryService.saveGenre(category);
    }

    @PutMapping("/{identifier}")
    public Genre updateCategory(@PathVariable Long identifier, @RequestBody Genre categoryDetails) {
        Genre category = categoryService.getGenreById(identifier);
        if (category != null) {
            category.setName(categoryDetails.getName());
            category.setMovies(categoryDetails.getMovies());
            return categoryService.saveGenre(category);
        }
        return null;
    }

    @DeleteMapping("/{identifier}")
    public void deleteCategory(@PathVariable Long identifier) {
        categoryService.deleteGenre(identifier);
    }
}
