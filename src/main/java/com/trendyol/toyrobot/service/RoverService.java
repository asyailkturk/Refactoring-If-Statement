package com.trendyol.toyrobot.service;

import com.trendyol.toyrobot.domain.Rover;
import com.trendyol.toyrobot.repository.RoverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverService {

    private final RoverRepository roverRepository;


    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public void move(String id) {
        Rover rover = roverRepository.findById(id);
        rover.move();
        roverRepository.update(rover);
    }

    public void turnLeft(String id) {
        Rover rover = roverRepository.findById(id);
        rover.turnLeft();
        roverRepository.update(rover);
    }

    public void turnRight(String id) {
        Rover rover = roverRepository.findById(id);
        rover.turnRight();
        roverRepository.update(rover);
    }

    public void placeRover(Rover rover) {
        roverRepository.save(rover);
    }

    public List<Rover> listRovers() {
        return roverRepository.findAll();
    }
}
