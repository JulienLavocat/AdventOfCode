package fr.julienlavocat.aoc.d02;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;

import fr.julienlavocat.aoc.utils.InputUtils;

public class Main02 {

    public static void main(String[] args) throws IOException {
        // System.out.println("Safe reports: " + runPart1(InputUtils.readInput("02",
        // 1)));
        System.out.println("Safe reports dampened: " + runPart2(InputUtils.readInput("02", 1)));
    }

    public static int runPart1(List<String> input) {
        var reports = input.stream()
                .map(line -> Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                .map(Main02::isReportSafe)
                .filter(isSafe -> isSafe)
                .collect(Collectors.toList());

        return reports.size();
    }

    public static int runPart2(List<String> input) {
        var reports = input.stream()
                .map(line -> Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray())
                .map(report -> {
                    if (isReportSafe(report))
                        return true;

                    for (int i = 0; i < report.length; i++) {
                        int[] dampenedReport = ArrayUtils.remove(report, i);
                        if (isReportSafe(dampenedReport))
                            return true;
                    }

                    return false;
                })
                .filter(isSafe -> isSafe)
                .collect(Collectors.toList());

        return reports.size();
    }

    public static boolean isReportSafe(int[] report) {
        boolean increasing = report[1] > report[0];
        for (int i = 1; i < report.length; i++) {
            int current = report[i];
            int previous = report[i - 1];
            int level = Math.abs(current - previous);

            if (level < 1 || level > 3) {
                System.out.println(Arrays.toString(report) + " unsafe: level " + level + ", " + previous
                        + " " + current);
                return false;
            }
            if (increasing && current - previous < 0) {
                System.out.println(
                        Arrays.toString(report) + "unsafe: increasing, " + previous + " " + current);
                return false;
            }
            if (!increasing && current - previous > 0) {
                System.out.println(
                        Arrays.toString(report) + "unsafe: decreasing, " + previous + " " + current);
                return false;
            }
        }

        return true;
    }

}
