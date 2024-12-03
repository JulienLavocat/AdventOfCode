package fr.julienlavocat.aoc.d01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import fr.julienlavocat.aoc.d02.Main02;
import fr.julienlavocat.aoc.utils.InputUtils;

public class Test02 {

    // @Test
    public void p1_shouldFind2SafeReports() throws IOException {
        var res = Main02.runPart1(InputUtils.readExample("02", 1));
        assertEquals(2, res);
    }

    @Test
    public void p2_shouldFind4SafeReportsWithDampener() throws IOException {
        var res = Main02.runPart2(InputUtils.readExample("02", 1));
        assertEquals(4, res);
    }

}
