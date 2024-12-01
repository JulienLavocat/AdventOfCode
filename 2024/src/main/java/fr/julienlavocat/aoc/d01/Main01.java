package fr.julienlavocat.aoc.d01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.julienlavocat.aoc.utils.InputUtils;

public class Main01 {

    public static void main(String[] args) throws IOException {
        System.out.println("RESULT P2: " + part1(InputUtils.readInput("01", 1)));
        System.out.println("RESULT P1: " + part2(InputUtils.readInput("01", 1)));
    }

    public static int part1(List<String> inputs) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        inputs.forEach(line -> {
            String[] parts = line.split(" ");
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[3]));
        });

        left.sort(Integer::compare);
        right.sort(Integer::compare);

        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            sum += Math.abs(left.get(i) - right.get(i));
        }

        return Math.abs(sum);
    }

    public static int part2(List<String> inputs) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        inputs.forEach(line -> {
            String[] parts = line.split(" ");
            left.add(Integer.parseInt(parts[0]));
            right.add(Integer.parseInt(parts[3]));
        });

        HashMap<Integer, Integer> occurences = new HashMap<>();
        right.forEach(element -> {
            occurences.merge(element, 1, Integer::sum);
        });

        int sum = 0;
        for (int i = 0; i < left.size(); i++) {
            int value = left.get(i);
            if (!occurences.containsKey(value)) {
                continue;
            }

            sum += occurences.get(value) * value;
        }

        return sum;
    }

}
