package com.ulfsvel.demo.unit.tests.cinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CinemaTest {

    private Cinema cinema;

    @BeforeEach
    public void setup() {
        cinema = new Cinema();
    }

    @Test
    public void givenNoMoviesWereAdded_whenGetNumberOfMovies_thenReturn0() {
        Assertions.assertEquals(0, cinema.getNumberOfMovies());
    }

    @Test
    public void givenMoviesWereAdded_whenGetNumberOfMovies_thenReturnNumberOfAddedMovies() {
        cinema.addMovie(new Movie());
        cinema.addMovie(new Movie());
        cinema.addMovie(new Movie());
        Assertions.assertEquals(3, cinema.getNumberOfMovies());
    }

    @Test
    public void givenMoviesWereAddedForADay_whenGetMoviesForDay_thenReturnMoviesForThatDayOrderedByIdAsc() {
        Movie movie1 = new Movie();
        movie1.setAirDay(Day.FRIDAY);
        movie1.setId(2L);
        Movie movie2 = new Movie();
        movie2.setAirDay(Day.FRIDAY);
        movie1.setId(1L);
        cinema.addMovie(movie1);
        cinema.addMovie(movie2);
        Assertions.assertEquals(Arrays.asList(movie1, movie2), cinema.getMoviesForDay(Day.FRIDAY));
    }

    @Test
    public void givenMoviesWereAddedForMultipleDays_whenGetMoviesForDay_thenReturnMoviesForThatDayOrderedByIdAsc() {
        Movie movie1 = new Movie();
        movie1.setAirDay(Day.FRIDAY);
        movie1.setId(1L);
        Movie movie2 = new Movie();
        movie2.setAirDay(Day.FRIDAY);
        movie2.setId(2L);
        Movie movie3 = new Movie();
        movie3.setAirDay(Day.SUNDAY);
        movie3.setId(3L);
        cinema.addMovie(movie1);
        cinema.addMovie(movie2);
        cinema.addMovie(movie3);
        Assertions.assertEquals(Arrays.asList(movie1, movie2), cinema.getMoviesForDay(Day.FRIDAY));
    }

}
