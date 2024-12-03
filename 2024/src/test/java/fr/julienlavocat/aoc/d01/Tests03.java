package fr.julienlavocat.aoc.d01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import fr.julienlavocat.aoc.d03.Main03;
import fr.julienlavocat.aoc.utils.InputUtils;

public class Tests03 {

    @Test
    public void part1_shouldReturn161() throws IOException {
        var res = Main03.runPart1(InputUtils.readExample("03", 1));
        assertEquals(161, res);
    }

    @Test
    public void part2_shouldReturn48() throws IOException {
        var res = Main03.runPart2(InputUtils.readExample("03", 2));
        assertEquals(48, res);
    }
}
