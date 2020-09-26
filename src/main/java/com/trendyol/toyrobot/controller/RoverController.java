package com.trendyol.toyrobot.controller;

import com.trendyol.toyrobot.domain.Rover;
import com.trendyol.toyrobot.service.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rovers")
public class RoverController {

    @Autowired
    private final RoverService roverService;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    @PostMapping
    public ResponseEntity<Void> placeRover(@RequestBody Rover rover) {
        roverService.save(rover);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Rover> listRovers() {
        return roverService.findAllRover();
    }

    @PostMapping("/{id}/turn-right")
    public Rover turnRight(@PathVariable String id) {
        return roverService.turnRight(id);
    }

    @PostMapping("/{id}/turn-left")
    public Rover turnLeft(@PathVariable String id) {
        return roverService.turnLeft(id);
    }

    @PostMapping("/{id}/move")
    public Rover move(@PathVariable String id) {
        return roverService.move(id);
    }
}
