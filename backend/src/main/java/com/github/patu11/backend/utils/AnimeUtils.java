package com.github.patu11.backend.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AnimeUtils {
    public static LocalDate parseDate(String date) {
        List<Integer> dateParts = Arrays.stream(date.split("\\.")).map(Integer::parseInt).toList();
        return LocalDate.of(dateParts.get(2), dateParts.get(1), dateParts.get(0));
    }
}
