package com.radioTransmitters;
// https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

import java.util.*;

public class TransmittersSolution {

    public int calculateTransmitters(int numberOfHouses, int transmitterRange, int[] houseMap) {
        double actualTransmitterRange = transmitterRange * 2 + 1;
        Arrays.sort(houseMap);

        int transmitters = 0;

        ArrayList<Integer> neighborhood = new ArrayList<>();
        neighborhood.add(houseMap[0]);

        if (numberOfHouses == 1) {
            transmitters = 1;
        }

        int counter = 1;
        for (int i = 1; i < numberOfHouses; i++) {
            if (houseMap[i] - houseMap[i - 1] <= transmitterRange) {
                neighborhood.add(counter, houseMap[i]);
                counter++;
            } else {
                transmitters += calculateTransmittersForNeighborhood(neighborhood, actualTransmitterRange);
                neighborhood = new ArrayList<>();
                neighborhood.add(0, houseMap[i]);
                counter = 1;
            }
            if (i == houseMap.length - 1) {
                transmitters += calculateTransmittersForNeighborhood(neighborhood, actualTransmitterRange);
                counter = 0;
            }
        }

        System.out.println(transmitters);
        return transmitters;

    }

    private int calculateTransmittersForNeighborhood(List<Integer> neighborhood, double actualTransmitterRange) {
        int numberOfTransmitters;
        if (neighborhood.size() == 1) {
            numberOfTransmitters = 1;
        } else {
            int firstHousePosition = neighborhood.get(0);
            int lastHousePosition = neighborhood.get(neighborhood.size() - 1);
            double houseRange = lastHousePosition - firstHousePosition + 1;

            numberOfTransmitters = (int) Math.ceil(houseRange / actualTransmitterRange);
        }
        return numberOfTransmitters;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfHouses = in.nextInt();
        int transmitterRange = in.nextInt();
        int[] houseMap = new int[numberOfHouses];
        for (int position = 0; position < numberOfHouses; position++) {
            houseMap[position] = in.nextInt();
        }
    }
}
