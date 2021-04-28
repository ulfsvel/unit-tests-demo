package com.ulfsvel.demo.unit.tests.cinema;

public class Movie {

    private Long id;

    private String name;

    private Day airDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Day getAirDay() {
        return airDay;
    }

    public void setAirDay(Day airDay) {
        this.airDay = airDay;
    }
}
