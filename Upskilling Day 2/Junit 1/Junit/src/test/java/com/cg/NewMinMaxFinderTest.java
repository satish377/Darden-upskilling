package com.cg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewMinMaxFinderTest {
	MinMaxFinder minMax;

	 

    @Test
    @DisplayName("Testing find Min Max Function")
    public void findMinMaxTest() {
        minMax = new MinMaxFinder();
        int arr[]= {5,8,2,9};
        int expected[]= {2,9};
        int actual[]= minMax.findMinMax(arr);
        assertTrue(Arrays.equals(expected, actual));

        int arr1[]= {51, -82, 0, 9};
        int expected1[]= {-82, 51};
        assertTrue(Arrays.equals(expected1, minMax.findMinMax(arr1)));

        int arr2[]= {0, 0, 0, 0};
        int expected2[]= {0, 0};
        assertTrue(Arrays.equals(expected2, minMax.findMinMax(arr2)));

        }
}
