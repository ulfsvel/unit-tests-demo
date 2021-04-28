package com.ulfsvel.demo.unit.tests.cinema;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cinema {

    private final List<Movie> dayMovieMap = new LinkedList<>();

    public Integer getNumberOfMovies() {
        return dayMovieMap.size();
    }

    public List<Movie> getMoviesForDay(Day day) {
        return dayMovieMap
                .stream()
                .filter(movie -> movie.getAirDay().equals(day))
                .sorted(Comparator.comparing(Movie::getId))
                .collect(Collectors.toList());
    }

    public void addMovie(Movie movie) {
        dayMovieMap.add(movie);
    }

}
