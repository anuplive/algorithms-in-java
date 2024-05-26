# Arrays

=================
## Table of contents

<!--ts--> 
| Category                                | Problems                              |                                         |                                                         |            |
|-----------------------------------------|---------------------------------------|-----------------------------------------|---------------------------------------------------------|------------|
| [Two Pointer](#Two-Pointer)             | [Valid Palindrome](#Valid-Palindrome) | [Three Sum Problem](#Three-Sum-Problem) | [Container with most Water](#Container-with-most-water) |            |
| [Triplet Sum](#Triplet-Sum)             |                                       |                                         |                                                         |            |
| [Sliding Window](#Sliding-Window)       |                                       |                                         |                                                         |            |
| [Merging Intervals](#Merging-Intervals) |                                       |                                         |                                                         |            |
|                                         |                                       |                                         |                                                         |            |


<!--te-->
***
[Back to Top](#Table-of-contents)
### Two Pointer

[Back to Top](#Table-of-contents)
#### Valid Palindrome

```java
/**
 Statement: Write a function that takes a string, s, as an input and determines whether or not it is a palindrome.
 */

import java.util.*;

public class Main{
    public static boolean isPalindrome(String s) {

        if(s == null || s.length() == 0)
            return false; 

        int start = 0; 
        int end = s.length() - 1; 

        while (end > start){
            if (s.charAt(end) != s.charAt(start))
                return false;
            start ++; 
            end --;    
        }

        return true;      
    }
}
/**
 Time complexity
 The time complexity is O(n), where n is the number of characters in the string. 
 However, our algorithm will only run O(n/2) times, since two pointers are traversing toward each other.

 Space complexity
 The space complexity is O(1), since we use constant space to store two indexes.
 */
```

#### Three Sum Problem

***
[Back to Top](#Table-of-contents)
### Triplet Sum
- Statement 
  Given an array of integers, nums, and an integer target.
  target, that is, nums[i] + nums[j] + nums[k] == target.

Determine if there are any three integers in nums whose sum equals target.
Return TRUE if such integers exist.
Return FALSE otherwise.

```java
import java.util.*; // Import the utility package which contains the Arrays class

public class SumOfThree {

    // Method to find if there are three numbers in the array that sum up to the target value
    public static boolean findSumOfThree(int[] nums, int target) {
        // Check if the input array is null or has less than 3 elements
        if (nums == null || nums.length < 3)
            return false;

        // Sort the array to enable the two-pointer approach
        Arrays.sort(nums);

        // Iterate through the array up to the third last element
        for (int i = 0 ; i < nums.length - 2 ; i ++) {
            int left = i + 1; // Initialize the left pointer to the element after the current one
            int right = nums.length - 1; // Initialize the right pointer to the last element of the array

            // While there are elements between the left and right pointers
            while (right > left) {
                // Check if the sum of the elements at the left and right pointers plus the current element equals the target
                if ((nums[left] + nums[right]) == (target - nums[i])) {
                    return true; // If found, return true
                } else if ((nums[left] + nums[right]) > (target - nums[i])) {
                    right--; // If the sum is greater than the target, move the right pointer to the left
                } else {
                    left++; // If the sum is less than the target, move the left pointer to the right
                }
            }
        }
        // If no such triplet is found, return false
        return false;
    }
}
```
##### Time Complexity
- Sorting the array: O(nlog(n))
- Nested loop: O(n^2)
- Total time complexity: O(nlog(n) + n^2) => O(n^2)

##### Space Complexity
- Using Arrays.sort(): O(log(n))

***
[Back to Top](#Table-of-contents)
#### Container with most Water
##### Statement 
- Given an integer array `height` of length `n`, and `n` vertical lines drawn such that the two endpoints of the `i-th` line are `(i, 0)` and `(i, height[i])`.
- Find two lines from the input array that, together with the x-axis, form a container that holds as much water as possible.
- Return the maximum amount of water a container can store.

```java
import java.util.*;

public class Solution {
    // Method to find the container with most water
    public static int containerWithMostWater(int[] height) {
        // Check if the height array is valid
        if (height == null || height.length < 2)
            return -1; // Not enough elements to form a container

        int start = 0; // Start index of the container
        int end = height.length - 1; // End index of the container
        int maxArea = Integer.MIN_VALUE; // Variable to store the maximum area

        // Loop until the two pointers meet
        while (end > start) {
            int width = end - start; // Calculate the width of the container
            int tempHeight = Math.min(height[end], height[start]); // Calculate the height of the container
            maxArea = Math.max(maxArea, width * tempHeight); // Update the maximum area

            // Move the pointer which has the smaller height
            if (height[end] < height[start]) {
                end--; // Move the end pointer inward
            } else {
                start++; // Move the start pointer inward
            }
        }

        return maxArea; // Return the maximum area found
    }
}

```
##### Time Complexity:
O(n) - where n is the length of the height array. This code makes a single pass through the array with two pointers.

##### Space Complexity:
O(1) - Constant extra space is used, regardless of the size of the input.



***
[Back to Top](#Table-of-contents)
### Sliding Window
```java
```

***
[Back to Top](#Table-of-contents)
### Merging Intervals
```java

```
