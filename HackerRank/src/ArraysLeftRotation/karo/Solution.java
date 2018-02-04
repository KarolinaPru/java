package ArraysLeftRotation.karo;

import java.util.*;
import static java.lang.Integer.valueOf;

public class Solution {
    public List applyLeftRotations(int[] input, int rotations) {
        List<Integer> inputAsList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            inputAsList.add(valueOf(input[i]));
        }

        if (rotations == input.length) {
            return inputAsList;
        }

        List secondPart = inputAsList.subList( 0, rotations);
        List firstPart = inputAsList.subList(rotations, input.length);

        List<Integer> output = new ArrayList<>();
        output.addAll(firstPart);
        output.addAll(secondPart);

        for (int i : output) {
            System.out.print(i + " ");
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numOfInts = in.nextInt();
        int rotations = in.nextInt();
        int ints[] = new int[numOfInts];
        for (int i = 0; i < numOfInts; i++) {
            ints[i] = in.nextInt();
        }
        Solution s = new Solution();
        s.applyLeftRotations(ints, rotations);
    }
}