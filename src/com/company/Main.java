package com.company;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = date.minusDays(5);
        LocalDate date2 = date.minusDays(8);
        LocalDate date3 = date.minusDays(29);
        LocalDate date4 = date.minusDays(256);
        LocalDate date5 = date.minusDays(214);
        LocalDate date6 = date.minusDays(159);

        LocalDate searchDate = LocalDate.of(2021, 8, 6);
        LocalDate latestDate = LocalDate.of(2022, 1, 10);
        LocalDate oldestDate = LocalDate.of(2022, 1, 1);

        Map<LocalDate, String> alexMap = new HashMap<>();
        alexMap.put(date, "Three musketeers");
        alexMap.put(date1, "Pinocchio");
        alexMap.put(date2, "Treasure Island");
        alexMap.put(date3, "Mysterious island");
        alexMap.put(date4, "Tarzan");
        alexMap.put(date5, "Mowgli. The Jungle Book");
        alexMap.put(date6, "Journey to the center of the earth");

        System.out.println(alexMap);

        int count = 0;
        for (Map.Entry<LocalDate, String> entry : alexMap.entrySet()) {
            if (entry.getKey().equals(searchDate)) {
                count++;
                System.out.println("\nIn day " + searchDate + " was taken book: " + entry.getValue());
            }
        }
        if (count == 0) {
            System.out.println("\nThere are no books have been taken this date: " + searchDate);
        }

        for (Map.Entry<LocalDate, String> entry : alexMap.entrySet()) {
            if (oldestDate.isAfter(entry.getKey())) {
                oldestDate = entry.getKey();
            } else if (latestDate.isBefore(entry.getKey())) {
                latestDate = entry.getKey();
            }
        }
        System.out.println("\nIn the date range " + "\"" + oldestDate + " - " + latestDate + "\"" + " the following list of books was taken: \n" +
                alexMap.values());
    }
}