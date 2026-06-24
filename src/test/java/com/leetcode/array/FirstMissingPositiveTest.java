package com.leetcode.array;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class FirstMissingPositiveTest {

    Solution sol = new Solution();

    // ===== 题目 Example =====

    static Stream<Arguments> examples() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 0}, 3),
            Arguments.of(new int[]{3, 4, -1, 1}, 2),
            Arguments.of(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("examples")
    void examples(int[] nums, int expected) {
        assertEquals(expected, sol.firstMissingPositive(nums));
    }

    // ===== 边界用例 =====

}
