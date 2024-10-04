package org.efrei.start.controllers;

import org.efrei.start.models.Actor;
import org.efrei.start.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService performerService;

    @GetMapping
    public List<Actor> getAllPerformers() {
        return performerService.getAllActors();
    }

    @GetMapping("/{identifier}")
    public Actor getPerformerById(@PathVariable Long identifier) {
        return performerService.getActorById(identifier);
    }

    @PostMapping
    public Actor createPerformer(@RequestBody Actor performer) {
        return performerService.saveActor(performer);
    }

    @PutMapping("/{identifier}")
    public Actor updatePerformer(@PathVariable Long identifier, @RequestBody Actor performerDetails) {
        Actor performer = performerService.getActorById(identifier);
        if (performer != null) {
            performer.setName(performerDetails.getName());
            performer.setMovies(performerDetails.getMovies());
            return performerService.saveActor(performer);
        }
        return null;
    }

    @DeleteMapping("/{identifier}")
    public void deletePerformer(@PathVariable Long identifier) {
        performerService.deleteActor(identifier);
    }
}
