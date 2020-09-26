package com.trendyol.toyrobot.repository;

import com.trendyol.toyrobot.domain.Rover;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoverRepository {

    private final JdbcTemplate jdbcTemplate;

    public RoverRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Rover findById(String id) {
        String query = "SELECT id, x, y, compass FROM rover WHERE id = ?";
        Object [] args = {id};
        return jdbcTemplate.queryForObject(query, args, new RoverRowMapper());
    }

    public void update(Rover rover) {
        String statement = "UPDATE rover SET x = ?, y = ?, compass = ? WHERE id = ?";
        Object [] args = {rover.getX(), rover.getY(), rover.getCompass().name(), rover.getId()};
        jdbcTemplate.update(statement, args);
    }

    public List<Rover> findAll() {
        String query = "SELECT id, x, y, compass FROM rover";
        return jdbcTemplate.query(query, new RoverRowMapper());
    }

    public void save(Rover rover) {
        String statement = "INSERT INTO rover (id, x, y, compass) VALUES (?, ?, ?, ?)";
        Object [] args = {rover.getId(), rover.getX(), rover.getY(), rover.getCompass().name()};
        jdbcTemplate.update(statement, args);
    }
}
