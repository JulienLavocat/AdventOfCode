package fr.julienlavocat.aoc.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class InputUtils {
    public static List<String> readExample(String day, int variant) throws IOException {
        return Files.lines(Paths.get(String.format("./inputs/%s/example%d.txt", day, variant))).toList();
    }

    public static List<String> readInput(String day, int variant) throws IOException {
        return Files.lines(Paths.get(String.format("./inputs/%s/input%d.txt", day, variant))).toList();
    }

}
