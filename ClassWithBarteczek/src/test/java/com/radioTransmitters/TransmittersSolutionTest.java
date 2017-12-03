package com.radioTransmitters;

import junitparams.naming.TestCaseName;
import org.junit.Test;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class TransmittersSolutionTest {
    private TransmittersSolution solution = new TransmittersSolution();

    @Test
    @Parameters(method = "params10, params2, params3, params4, params5, params6, params7, params8, params9, params1")
    @TestCaseName("{0}, {1}, {2}, {3}")
    public void test(int numberOfHouses, int transmitterRange, int[] houseMap, int expected) {
        int actualNumberOfTransmitters = solution.calculateTransmitters(numberOfHouses, transmitterRange, houseMap);

        assertThat(actualNumberOfTransmitters).isEqualTo(expected);
    }

    private Object params1() {
        int numberOfHouses = 5;
        int transmitterRange = 1;
        int[] houseMap = {1, 2, 3, 4, 5};
        int expected = 2;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params2() {
        int numberOfHouses = 3;
        int transmitterRange = 1;
        int[] houseMap = {1, 2, 3};
        int expected = 1;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params3() {
        int numberOfHouses = 8;
        int transmitterRange = 2;
        int[] houseMap = {7, 2, 4, 6, 5, 9, 12, 11};
        int expected = 3;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params4() {
        int numberOfHouses = 5;
        int transmitterRange = 1;
        int[] houseMap = {1, 30, 21, 20, 50};
        int expected = 4;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params5() {
        int numberOfHouses = 20;
        int transmitterRange = 5;
        int[] houseMap = {1, 8, 30, 20, 50, 99, 128, 500, 99, 1000, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 3000 };
        int expected = 19;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params6() {
        int numberOfHouses = 4;
        int transmitterRange = 1;
        int[] houseMap = {1, 2, 3, 500};
        int expected = 2;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params7() {
        int numberOfHouses = 50;
        int transmitterRange = 2;
        int[] houseMap = {
                1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000,
                200000, 200000, 200000, 200000, 200000, 200000, 200000, 200000, 200000, 200000,
                40000, 40000, 40000, 40000, 40000, 40000, 40000, 40000, 40000, 40000,
                444444, 444444, 444444, 444444, 444444, 444444, 444444, 444444, 444444, 444444,
                222222, 222222, 222222, 222222, 222222, 222222, 222222, 222222, 222222, 222222
        };
        int expected = 5;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params8() {
        int numberOfHouses = 8;
        int transmitterRange = 2;
        int[] houseMap = {2, 2, 2, 2, 1, 1, 1, 1};
        int expected = 1;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params9() {
        int numberOfHouses = 1;
        int transmitterRange = 1;
        int[] houseMap = {1};
        int expected = 1;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }

    private Object params10() {
        int numberOfHouses = 10;
        int transmitterRange = 2;
        int[] houseMap = {
                100,
                400,
                444,
                220,
                223,
                223,
                224,
                224,
                227,
                228,
        };
        int expected = 5;
        return $(
                $(numberOfHouses, transmitterRange, houseMap, expected)
        );
    }
}
