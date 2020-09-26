package com.trendyol.toyrobot.service;

import com.trendyol.toyrobot.domain.Rover;
import com.trendyol.toyrobot.repository.RoverRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverService {

    private final RoverRepository roverRepository;

    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public void save(Rover rover) {
        try {
            roverRepository.save(rover);
        } catch (ConstraintViolationException e) {

        }
    }

    public List<Rover> findAllRover() {
        return roverRepository.findAll();
    }

    public Rover turnRight(String id) {
        Rover rover = roverRepository.getOne(id);
        rover.turnRight();
        return roverRepository.save(rover);
    }

    public Rover turnLeft(String id) {
        var rover = roverRepository.getOne(id);
        rover.turnLeft();
        return roverRepository.save(rover);
    }

    public Rover move(String id) {
        var rover = roverRepository.getOne(id);
        rover.move();
        return roverRepository.save(rover);
    }
}
