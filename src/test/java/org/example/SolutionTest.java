package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    private final String CORRECT_RESULT = "24.0";
    private final String INCORRECT_RESULT = "Can not get 24";
    Solution solution = new Solution();

    @Test
    void correctInput_Ok() {
        String solution = this.solution.find24(new int[]{2, 11, 2, 0});
        int index = solution.lastIndexOf(CORRECT_RESULT);
        String result = solution.substring(index);
        Assertions.assertEquals(result, CORRECT_RESULT);
    }

    @Test
    void notNullInput_Ok() {
        String solution = this.solution.find24(new int[]{4,1,8,7});
        int index = solution.lastIndexOf(CORRECT_RESULT);
        String result = solution.substring(index);
        Assertions.assertEquals(result, CORRECT_RESULT);
    }

    @Test
    void notValidInput_Ok() {
        String solution = this.solution.find24(new int[]{1, 1, 1, 0});
        Assertions.assertEquals(solution, INCORRECT_RESULT);
    }

    @Test
    void emptyInput_Ok() {
        String solution = this.solution.find24(new int[]{});
        Assertions.assertEquals(solution, INCORRECT_RESULT);
    }
}