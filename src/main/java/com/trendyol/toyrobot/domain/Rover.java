package com.trendyol.toyrobot.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "rovers", uniqueConstraints = {
        @UniqueConstraint(name = "coordinates", columnNames = {
                "x",
                "y"
        })
})
public class Rover {

    @Id
    @Column(unique = true, updatable = false, length = 50)
    private String id;

    @Column(name = "x")
    private int x;

    @Column(name = "y")
    private int y;

    @Column(length = 5)
    @Enumerated(value = EnumType.STRING)
    private Compass compass;

    @Column(name = "yearOfManufacture", length = 4)
    private Long yearOfManufacture;

    @ManyToOne
    private Country country;

    public Rover() {
        this.id = UUID.randomUUID().toString();
        this.x = 0;
        this.y = 0;
        this.compass = Compass.NORTH;
        this.yearOfManufacture = 1900L;
    }

    public Rover(String id, int x, int y, Compass compass, Long yearOfManufacture) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.compass = compass;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Rover(int x, int y, Compass compass) {
        this.x = x;
        this.y = y;
        this.compass = compass;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Long yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void move() {
        if (Compass.NORTH.equals(this.compass)) {
            this.y = this.y + 1;
        } else if (Compass.EAST.equals(this.compass)) {
            this.x = this.x + 1;
        } else if (Compass.SOUTH.equals(this.compass)) {
            this.y = this.y - 1;
        } else if (Compass.WEST.equals(this.compass)) {
            this.x = this.x - 1;
        }
    }

    public void turnLeft() {
        if (Compass.NORTH.equals(this.compass)) {
            this.compass = Compass.WEST;
        } else if (Compass.WEST.equals(this.compass)) {
            this.compass = Compass.SOUTH;
        } else if (Compass.SOUTH.equals(this.compass)) {
            this.compass = Compass.EAST;
        } else if (Compass.EAST.equals(this.compass)) {
            this.compass = Compass.NORTH;
        }
    }

    public void turnRight() {
        if (Compass.NORTH.equals(this.compass)) {
            this.compass = Compass.EAST;
        } else if (Compass.EAST.equals(this.compass)) {
            this.compass = Compass.SOUTH;
        } else if (Compass.SOUTH.equals(this.compass)) {
            this.compass = Compass.WEST;
        } else if (Compass.WEST.equals(this.compass)) {
            this.compass = Compass.NORTH;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Compass getCompass() {
        return this.compass;
    }
}
