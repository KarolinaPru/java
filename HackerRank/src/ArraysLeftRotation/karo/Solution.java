package ArraysLeftRotation.karo;

import java.util.*;
import static java.lang.Integer.valueOf;

public class Solution {
    public List applyLeftRotations(int[] input, int rotations) {
        List<Integer> output = new ArrayList<>();
        List<Integer> tail = new ArrayList<>();
        if (rotations == input.length) {
            return output;
        }

        for (int i = 0; i < input.length; i++) {
            if ( i < rotations) {
                tail.add(valueOf(input[i]));
            } else {
                output.add(valueOf(input[i]));
            }
        }

        output.addAll(tail);

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