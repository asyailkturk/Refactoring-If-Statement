package com.trendyol.toyrobot.repository;

import com.trendyol.toyrobot.domain.Rover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoverRepository extends JpaRepository<Rover, String> {
}
