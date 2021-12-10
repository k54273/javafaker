package com.github.javafaker;

import org.junit.Test;
import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class FlightTest extends AbstractFakerTest {

    @Test
    // check if getDigits function returns empty or null string
    public void testGetDigitsNull() {
        final String digit = String.valueOf(faker.flight().getDigits());
        assertThat(digit, not(isEmptyOrNullString()));
    }

    @Test
    // generate a random number in range 1-9999
    public void testGetDigits() {
        final String digit = String.valueOf(faker.flight().getDigits());
        assertThat(digit, matchesRegularExpression("[1-9][0-9]{0,3}"));
    }

    @Test
    // check if getLetters function returns empty or null string
    public void testGetLettersNull() {
        final String letter = faker.flight().getLetters(1);
        assertThat(letter, not(isEmptyOrNullString()));
    }

    @Test
    // generate two random capital letters
    public void testGetLetters() {
        final String letter = faker.flight().getLetters(2);
        assertThat(letter, matchesRegularExpression("[A-Z][A-Z]"));
    }

    @Test
    // generate three random capital letters
    public void testGetLetters2() {
        final String letter = faker.flight().getLetters(3);
        assertThat(letter, matchesRegularExpression("[A-Z][A-Z][A-Z]"));
    }

    @Test
    // check if getIataFlight function returns empty or null string
    public void testGetIataFlightNull() {
        final String letter = faker.flight().getIataFlight();
        assertThat(letter, not(isEmptyOrNullString()));
    }

    @Test
    // generate a random Iata flight number
    public void testGetIataFlight() {
        final String letter = faker.flight().getIataFlight();
        assertThat(letter, matchesRegularExpression("[A-Z][A-Z][1-9][0-9]{0,3}"));
    }

    @Test
    // check if getIcaoFlight function returns empty or null string
    public void testGetIcaoFlightNull() {
        final String letter = faker.flight().getIcaoFlight();
        assertThat(letter, not(isEmptyOrNullString()));
    }

    @Test
    // generate a random Icao flight number
    public void testGetIcaoFlight() {
        final String letter = faker.flight().getIcaoFlight();
        assertThat(letter, matchesRegularExpression("[A-Z][A-Z][A-Z][1-9][0-9]{0,3}"));
    }

    @Test
    // check if getAirlineName function returns empty or null string
    public void testGetAirlineNameNull() {
        final String name = faker.flight().getAirlineName();
        assertThat(name, not(isEmptyOrNullString()));
    }

    @Test
    // generate a random two word airline name
    public void testGetAirlineName() {
        final String name = faker.flight().getAirlineName();
        assertThat(name, matchesRegularExpression("[A-Z][a-z]{2,10} [A-Z][a-z]{2,11}"));
    }
}