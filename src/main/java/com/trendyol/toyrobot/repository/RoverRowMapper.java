package com.trendyol.toyrobot.repository;

import com.trendyol.toyrobot.domain.Compass;
import com.trendyol.toyrobot.domain.Rover;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoverRowMapper implements RowMapper<Rover> {
    @Override
    public Rover mapRow(ResultSet resultSet, int i) throws SQLException {
        String id = resultSet.getString("id");
        int x = resultSet.getInt("x");
        int y = resultSet.getInt("y");
        String compass = resultSet.getString("compass");
        return new Rover(id, x, y, Compass.valueOf(compass));
    }
}
