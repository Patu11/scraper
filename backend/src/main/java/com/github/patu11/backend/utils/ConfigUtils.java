package com.github.patu11.backend.utils;

import java.io.File;

public class ConfigUtils {
    public static boolean isDockerized() {
        File f = new File("/.dockerenv");
        return f.exists();
    }
}
