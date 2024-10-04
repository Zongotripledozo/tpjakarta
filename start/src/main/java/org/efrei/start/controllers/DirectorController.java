package org.efrei.start.controllers;

import org.efrei.start.models.Director;
import org.efrei.start.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/{id}")
    public Director getDirectorById(@PathVariable String id) {
        return directorService.getDirectorById(id);
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorService.saveDirector(director);
    }

    @PutMapping("/{id}")
    public Director updateDirector(@PathVariable String id, @RequestBody Director directorDetails) {
        Director director = directorService.getDirectorById(id);
        if (director != null) {
            director.setName(directorDetails.getName());
            director.setMovies(directorDetails.getMovies());
            return directorService.saveDirector(director);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable String id) {
        directorService.deleteDirector(id);
    }
}
