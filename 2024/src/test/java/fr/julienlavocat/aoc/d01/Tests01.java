package fr.julienlavocat.aoc.d01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import fr.julienlavocat.aoc.utils.InputUtils;

public class Tests01 {

    @Test
    public void P1_shouldMatchTestInput() throws IOException {
        int result = Main01.part1(InputUtils.readExample("01", 1));
        assertEquals(11, result);
    }

    @Test
    public void P2_shouldMatchTestInput() throws IOException {
        int result = Main01.part2(InputUtils.readExample("01", 1));
        assertEquals(31, result);
    }
}
