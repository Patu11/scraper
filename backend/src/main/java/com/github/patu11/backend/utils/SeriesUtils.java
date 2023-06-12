package com.github.patu11.backend.utils;

public class SeriesUtils {
    public static boolean isValidSeriesDate(String date) {
        String[] split = date.split("-");
        return split.length != 1;
    }
}
