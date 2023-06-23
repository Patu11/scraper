package com.github.patu11.backend.utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AnimeUtils {
    private static final Map<String, Integer> MONTHS = new HashMap<>() {{
        put("Jan.", 1);
        put("Feb.", 2);
        put("Mar.", 3);
        put("Apr.", 4);
        put("May", 5);
        put("Jun.", 6);
        put("Jul.", 7);
        put("Aug.", 8);
        put("Sep.", 9);
        put("Oct.", 10);
        put("Nov.", 11);
        put("Dec.", 12);
    }};

    public static LocalDate parseDate(String date) {
        return LocalDate.of(getYear(date), getMonth(date), getDay(date));
    }

    private static int getDay(String date) {
        return Integer.parseInt(date.split("\\s+")[0]);
    }

    private static int getMonth(String date) {
        return MONTHS.get(date.split("\\s+")[1]);
    }

    private static int getYear(String date) {
        String[] split = date.split("\\s+");
        return Integer.parseInt(split[split.length - 1]);
    }
}
