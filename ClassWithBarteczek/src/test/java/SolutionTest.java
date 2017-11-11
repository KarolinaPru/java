
import com.karolina.Solution;
import junitparams.naming.TestCaseName;
import org.junit.Test;

import static junitparams.JUnitParamsRunner.$;
import static org.assertj.core.api.Assertions.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    @Parameters(method = "params1, params2, params3")
    @TestCaseName("{0}, {1}, {2}")
    public void givenArrayOfInts_whenTwoOfThemAddUpToTarget_thenTheirIndicesAreReturned(int target, int[] nums, int[] expected) {
        int[] actualIndices = solution.twoSum(nums, target);

        assertThat(actualIndices).containsExactlyInAnyOrder(expected);
    }

    private Object params1() {
        int[] nums = {1, 2};
        int target = 3;
        int[] expected = {0, 1};
        return $(
                $(target, nums, expected)
        );
    }

    private Object params2() {
        int[] nums = {1, 2, 3};
        int target = 4;
        int[] expected = {0, 2};
        return $(
                $(target, nums, expected)
        );
    }

    private Object params3() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        int[] expected = {3, 4};
        return $(
                $(target, nums, expected)
        );
    }
}