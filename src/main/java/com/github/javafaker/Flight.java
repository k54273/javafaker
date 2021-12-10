package com.github.javafaker;

import java.util.Random;

/**
 * Generate random flight numbers and airline names.
 * @author k54273
 */
public class Flight {
    /**
     * Create a constructor for Flight.
     */
    protected Flight() {
    }

    /**
     * Generate random digit in range 1-9999.
     * @return randomly generated digit
     */
    public int getDigits() {
        final int min = 1;
        final int max = 9999;

        return (int)(Math.random() * (max - min + 1));
    }

    /**
     * Generate random capital letters.
     * @param iterations The number of random capital letters to generate
     * @return randomly generated letters
     */
    public String getLetters(int iterations) {
        StringBuilder letters = new StringBuilder();
        char first = 'A';
        char last = 'Z';

        for (int i = 0; i < iterations; i++) {
            Random r = new Random();
            char c = (char)(r.nextInt(last - first + 1) + first);
            letters.append(c);
        }

        return String.valueOf(letters);
    }

    /**
     * Generate random Iata flight number.
     * @return randomly generated Iata flight number
     */
    public String getIataFlight() {
        String result;
        final int iterations = 2;

        int digits = getDigits();
        String letters = getLetters(iterations);
        result = letters + digits;

        return result;
    }

    /**
     * Generate random Icao flight number.
     * @return randomly generated Icao flight number
     */
    public String getIcaoFlight() {
        String result;
        final int iterations = 3;

        int digits = getDigits();
        String letters = getLetters(iterations);
        result = letters + digits;

        return result;
    }

    /**
     * Generate random airline name.
     * @return randomly generated airline name
     */
    public String getAirlineName() {
        String[] airlineNames = new String[]{"Fly Service", "Global Alliance", "Engineering Space", "Jet Team",
                "Ironclad Air", "Assured Atmosphere", "Arrive Safe", "Premiere Protection", "Sky Shop",
                "Air Innovations", "Capable Craft", "Hightail Demo", "Shift Airways", "Space Safe", "Jet World",
                "Luxury Spot", "Exotic Airline", "Global Traveler", "Airway Moment", "Smart Wing", "Volts Aerospace",
                "Tourism Help", "Aero One", "Safe Escape", "Nonstop Trip", "Homeland Innovations",
                "Economy Speed", "Front Desk", "Tactical Takeoff", "Forge Aerodynamics", "Spark Airways"};

        int min = 0;
        int max = airlineNames.length;

        int index = (int)(Math.random() * (max - min));

        return airlineNames[index];
    }
}