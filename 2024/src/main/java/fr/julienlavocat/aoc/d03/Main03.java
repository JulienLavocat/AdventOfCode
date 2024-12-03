package fr.julienlavocat.aoc.d03;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.julienlavocat.aoc.utils.InputUtils;

public class Main03 {

    public static void main(String[] args) throws IOException {
        System.out.println("Part 1: " + runPart1(InputUtils.readInput("03", 1)));
        System.out.println("Part 2: " + runPart2(InputUtils.readInput("03", 1)));
    }

    public static long runPart1(List<String> input) {
        long result = 0;
        for (String line : input) {
            Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String operation = matcher.group();
                result += multiplyOperation(operation);
            }
        }
        return result;
    }

    public static long runPart2(List<String> input) {
        long result = 0;
        boolean canMultiply = true;
        for (String line : input) {
            Pattern pattern = Pattern.compile("(mul\\((\\d{1,3}),(\\d{1,3})\\))|(do\\(\\))|(don't\\(\\))");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String operation = matcher.group();
                switch (operation) {
                    case "do()":
                        canMultiply = true;
                        break;
                    case "don't()":
                        canMultiply = false;
                        break;
                    default:
                        if (canMultiply)
                            result += multiplyOperation(operation);
                        break;
                }
            }
        }
        return result;
    }

    public static long multiplyOperation(String operation) {
        int commaIndex = operation.indexOf(',');

        String a = operation.substring(4, commaIndex);
        String b = operation.substring(commaIndex + 1, operation.length() - 1);

        // System.out.println(operation + " -> " + a + " " + b);
        return Integer.parseInt(a) * Integer.parseInt(b);
    }
}
