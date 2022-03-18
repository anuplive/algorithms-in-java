# Arrays

## Table of contents
=================
<!--ts-->
* [Sorting Array](#Sorting-Array)
* [Sliding Window](#Sliding-Window)
  * Finding Substrings with limits on distinct characters.
  * Find Max in sliding windows 
* [Two Pointer](#Two-Pointer)
  * With Sorting, Without Sorting
* [Two OR Three numbers SUM](#Two-OR-Three-numbers-SUM)
  * Two Pointer Style 
* [Nth Smallest OR Largest](#Nth-Smallest-OR-Largest)
* [Remove from Array](#Remove-from-Array)
  * Duplicates, requires sorting OR use HashSet
  * WhiteSpaces, Zeros, Even Numbers , does not require sorting
* [Kadanes Algorithm](#Kadanes-Algorithm)
  * Maximum Sum Subarray, Stocks Buy Sell
<!--te-->

## Sorting Array
---
### Insertion Sort
#### TC: O(n^2)  , MC: O(1)
- Worst case id Array is reverse sorted
- Best case is alreday sorted
- [Back to Top](#Table-of-contents)
```java
void sort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    } 
```
---

### Merge Sort
#### TC: O(NlogN) , MC: O(N)
- Split the array in the mid till start < end
- Then keep merging the array using 
- - [Back to Top](#Table-of-contents)
```java
public int[] sortArray(int[] nums) {
     mergesort(nums, 0, nums.length-1);
     return nums;
    }
    public void mergesort(int[] nums, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergesort(nums, start, mid);
            mergesort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }
    
    public void merge(int[] nums, int start, int mid, int end){
    int i= start;
    int j= mid+1;
    int[] temp = new int[end-start+1];
    int k=0; 
    while( i <= mid && j<= end)
    {
        if (nums[i] < nums[j])
            temp[k++] = nums[i++];
        else
            temp[k++] = nums[j++];
    }
    while (i <= mid) { temp[k++] = nums[i++]; } //copy remaining elements
    while (j <= end) { temp[k++] = nums[j++]; } //copy remaining elements
    for (int pointer = start; pointer <= end; pointer++){
        nums[pointer] = temp[pointer-start];
    }
  }
```
---
### Quicksort Algorithm
#### TC: O(NlogN)  , MC: O(logN)
- Recursive Algo has three parts
  - partition: divides the array at pivot
  - quickSortRec: Recursively calls the Quick Sort
  - quickSort: Initializes the algo
- [Back to Top](#Table-of-contents)
```java
static int partition(int[] arr, int low, int high) {
		// Initializing pivot's index to low
		int pivotValue = arr[low];
		int i = low;
		int j = high;
		// Loop till i pointer crosses j pointer
		while (i < j) {
			// Increment the 'i' pointer till it finds an element greater than pivot
			while (i <= high && arr[i] <= pivotValue)
				i++;
			// Decrement the 'j' pointer till it finds an element less than pivot
			while (arr[j] > pivotValue)
				j--;
			// Swap the numbers on 'i' and 'j'
			if (i < j) {
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// Swap pivot element with element on 'j' pointer.
		arr[low] = arr[j];
		arr[j] = pivotValue;
		// return the pivot index
		return j;
	}
	// Recursive function implementing QuickSort
	static void quickSortRec(int[] arr, int low, int high) {
		if (high > low) {
			// pivot_index is the partitioning index
			int pivotIndex = partition(arr, low, high);

			// Sort elements before partition
			quickSortRec(arr, low, pivotIndex - 1);

			// Sort elements after partition
			quickSortRec(arr, pivotIndex + 1, high);
		}
	}
	static void quickSort(int[] arr) {
		quickSortRec(arr, 0, arr.length - 1);
	} 
```
---
### Cyclic Sort
#### TC:O(N)  , MC: O(1) ,Easy
- Iterate from i = 0
  - increment i only if a[i] == i + 1
  - else keep swap( a[i], a[a[i] -1])
- [Back to Top](#Table-of-contents)
```java
  public static void sort(int[] nums) {
    // TODO: Write your code here
   int i = 0; 
   while(i < nums.length){
     if (nums[i]!= i + 1){
       int temp = nums[nums[i]-1];
       nums[nums[i] -1] = nums[i];
       nums[i] = temp;
     }else{
       i ++;
     }
   }
  } 
```
---

## Sliding Window
---
### Maximum Sum Subarray of Size K
#### TC: O(N)  , MC: O(1), Easy
[Back to Top](#Table-of-contents)
- Hint: Have a start pointer, and a currentWindowSum
  - Iterate through the array
    - Keep adding to the currentSum
      - If the iterator value > Size K , then currentSum -= array[start++]
    - compare the currentSum with globalMax Sum 
```java
 public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int start = 0;
    int currentWindowSum = 0;
    int maxWindowSum = Integer.MIN_VALUE;
    for (int end = 0; end < arr.length; end ++){
      currentWindowSum += arr[end]; 
      if (end > k -1){
        currentWindowSum -= arr[start]; 
        start += 1; 
      }
      maxWindowSum = Integer.max(maxWindowSum, currentWindowSum);
    }
    return (maxWindowSum == Integer.MIN_VALUE)? -1 : maxWindowSum;
  }
```

---
### Smallest Subarray With a Sum greater than Target 
#### TC:  , MC:
- [Back to Top](#Table-of-contents)
```java
public static int findMinSubArray(int S, int[] arr) {

        int start = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int currentWindowSum = 0;

        for (int end = 0; end < arr.length; end ++ ){
        currentWindowSum += arr[end];

        while( currentWindowSum >= S){
        minWindowLength = Integer.min(minWindowLength, end - start + 1);
        currentWindowSum -= arr[start];
        start ++;
        }
        }
        return (minWindowLength == Integer.MAX_VALUE) ? -1 : minWindowLength;
        }


```
---
### Longest Substring with maximum K Distinct Characters
#### TC: O(N) , MC: O(N)
- [Back to Top](#Table-of-contents)
```java
public static int findLength(String str, int k) {
    if (str == null || str.length() == 0)
      throw new IllegalArgumentException();

    int windowStart = 0, maxLength = 0;
    Map<Character, Integer> charFrequencyMap = new HashMap<>();
    // in the following loop we'll try to extend the range [windowStart, windowEnd]
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
      // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
      while (charFrequencyMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
        if (charFrequencyMap.get(leftChar) == 0) {
          charFrequencyMap.remove(leftChar);
        }
        windowStart++; // shrink the window
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
    }

    return maxLength;
  }


```
---
### Longest Substring with Distinct Characters
#### TC: O(N) , MC: O(K)
- [Back to Top](#Table-of-contents)
```java
public int lengthOfLongestSubstring(String s) {
        
        char[] arr = s.toCharArray();
        HashSet<Character> charSet = new HashSet<Character>();
        int windowStart = 0;
        int maxLength = Integer.MIN_VALUE;
        
        for (int end = 0; end < arr.length; end ++){
                char rightChar = arr[end];
                while (charSet.contains(rightChar))
                {
                    charSet.remove(arr[windowStart]);
                    windowStart += 1;
                } 
                
                charSet.add(rightChar);
                maxLength = Integer.max(maxLength, end - windowStart + 1 );
                } 
        
        return ( maxLength == Integer.MIN_VALUE) ? 0 : maxLength;
}
```
---
### Find Maximum in Sliding Window
#### TC: O(N) , MC: O(w)
- For each of the window create a queue
- add the element in the queue if if next elemnt is greater
- [Back to Top](#Table-of-contents)
```java
public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
		ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
		Deque<Integer> list = new ArrayDeque<Integer>(); // creating a linked list

		if (arr.length > 0) {
			// If window_size is greater than the array size,
			// set the window_size to nums.size()
			if (arr.length < windowSize)
				windowSize = arr.length;
			for (int i = 0; i < windowSize; ++i) {
				// Removing last smallest element index
				while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
					list.removeLast();
				}

				// Adding newly picked element index
				list.addLast(i);
			}

			for (int i = windowSize; i < arr.length; ++i) {
				result.add(arr[list.peek()]);

				// Removing all the elements indexes which are not in the current window
				while ((!list.isEmpty()) && list.peek() <= i - windowSize)
					list.removeFirst();

				// Removing the smaller elements indexes which are not required
				while ((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
					list.removeLast();

				// Adding newly picked element index
				list.addLast(i);
			}

			// Adding the max number of the current window in the result
			result.add(arr[list.peek()]);
			return result; // returning result
		} else
			return result;
	}
```
---
### Sub arrays with Product Less than a Target.
#### TC: O(N)  MC: O(N)  ,
- Some Comments 
- [Back to Top](#Table-of-contents)
```java
 public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    double product = 1;
    int left = 0;
    for (int right = 0; right < arr.length; right++) {
      product *= arr[right];
      while (product >= target && left < arr.length)
        product /= arr[left++];
      // since the product of all numbers from left to right is less than the target therefore,
      // all subarrays from left to right will have a product less than the target too; to avoid
      // duplicates, we will start with a subarray containing only arr[right] and then extend it
      List<Integer> tempList = new LinkedList<>();
      for (int i = right; i >= left; i--) {
        tempList.add(0, arr[i]);
        result.add(new ArrayList<>(tempList));
      }
    }
    return result;
  }
```
---

## Two Pointer
### Squaring an Array
#### TC: O(NLogN)  , MC: O(N)
- Sort the Array, take two pointers at end populate the result[] from last index
- [Back to Top](#Table-of-contents)
```java
public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int squareIndex = arr.length -1 ;
    int left = 0, right = arr.length - 1;

    while (left < right){
      int rightSquare = arr[right] * arr[right];
      int leftSquare = arr[left] * arr[left];

      if(leftSquare > rightSquare){
        squares[squareIndex--] = leftSquare;
        left++;
      }else {
        squares[squareIndex--] = rightSquare;
        right--;
      }
    }  
    return squares;
  }
```
---
### Dutch National Flag Problem
#### TC: O(N) , MC: O(1)
- Take two pointers Low and High, iterate array with index i
- If arr[i] == 0, swap i with Low, I ++ and Low ++
- If arr[i] == 1,  I ++
- If arr[i] == 2, swap i with High, I ++ and High ++
- [Back to Top](#Table-of-contents)
```java
public static void sort(int[] arr) {
    // all elements < low are 0 and all elements > high are 2
    // all elements from >= low < i are 1
    int low = 0, high = arr.length - 1;
    for (int i = 0; i <= high;) {
      if (arr[i] == 0) {
        swap(arr, i, low);
        // increment 'i' and 'low'
        i++;
        low++;
      } else if (arr[i] == 1) {
        i++;
      } else { // the case for arr[i] == 2
        swap(arr, i, high);
        // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
        high--;
      }
    }
  }
```
---

---

## Two OR Three numbers SUM
---
### Pair with Target Sum
#### TC:O(N)  , MC:O(1)
- Sort the array, Two pointers at start and end; 
- [Back to Top](#Table-of-contents)
```java
public static int[] search(int[] arr, int targetSum) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == targetSum)
        return new int[] { left, right }; // found the pair

      if (targetSum > currentSum)
        left++; // we need a pair with a bigger sum
      else
        right--; // we need a pair with a smaller sum
    }
    return new int[] { -1, -1 };
  }
```
---

---
### Triplet Sum to Zero
#### TC: O(N^2)  , MC: O(N)
- Sort the Array, Iterate from Start using Index
- TargetSum: - arr[Index], Left = Index
- Find the TargetSum in the left of Index using Two Sum Problem  
- [Back to Top](#Table-of-contents)
```java
public static List<List<Integer>> searchTriplets(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> triplets = new ArrayList<>();
    for (int i = 0; i < arr.length - 2; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
        continue;
      searchPair(arr, -arr[i], i + 1, triplets);
    }
    return triplets;
  }

  private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
    int right = arr.length - 1;
    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == targetSum) { // found the triplet
        triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1])
          left++; // skip same element to avoid duplicate triplets
        while (left < right && arr[right] == arr[right + 1])
          right--; // skip same element to avoid duplicate triplets
      } else if (targetSum > currentSum)
        left++; // we need a pair with a bigger sum
      else
        right--; // we need a pair with a smaller sum
    }
  }

```
---



---

---
### Triplet Sum Close to Target
#### TC: O(N^2) , MC: O(N)
- Sort the Array, Iterate at Index
- Left is start Pointer and Right is Tail Pointer 
- Record the targetDiff at each Index and compare with smallestDiff
- [Back to Top](#Table-of-contents)
```java
public static int searchTriplet(int[] arr, int targetSum) {
    if (arr == null || arr.length < 3)
      throw new IllegalArgumentException();

    Arrays.sort(arr);
    int smallestDifference = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 2; i++) {
      int left = i + 1, right = arr.length - 1;
      while (left < right) {
        // comparing the sum of three numbers to the 'targetSum' can cause overflow
        // so, we will try to find a target difference
        int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
        if (targetDiff == 0) //  we've found a triplet with an exact sum
          return targetSum; // return sum of all the numbers

        // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
        if (Math.abs(targetDiff) < Math.abs(smallestDifference)
            || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
          smallestDifference = targetDiff; // save the closest and the biggest difference  

        if (targetDiff > 0)
          left++; // we need a triplet with a bigger sum
        else
          right--; // we need a triplet with a smaller sum
      }
    }
    return targetSum - smallestDifference;
  }
```
---
---
### Quadruple Sum to Target
#### TC: O(N^3) , MC: O(N)
- Multi loop
- [Back to Top](#Table-of-contents)
```java
public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
    Arrays.sort(arr);
    List<List<Integer>> quadruplets = new ArrayList<>();
    for (int i = 0; i < arr.length - 3; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate quadruplets
        continue;
      for (int j = i + 1; j < arr.length - 2; j++) {
        if (j > i + 1 && arr[j] == arr[j - 1]) // skip same element to avoid duplicate quadruplets
          continue;
        searchPairs(arr, target, i, j, quadruplets);
      }
    }
    return quadruplets;
  }

  private static void searchPairs(int[] arr, int targetSum, int first, int second, List<List<Integer>> quadruplets) {
    int left = second + 1;
    int right = arr.length - 1;
    while (left < right) {
      int sum = arr[first] + arr[second] + arr[left] + arr[right];
      if (sum == targetSum) { // found the quadruplet
        quadruplets.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
        left++;
        right--;
        while (left < right && arr[left] == arr[left - 1])
          left++; // skip same element to avoid duplicate quadruplets
        while (left < right && arr[right] == arr[right + 1])
          right--; // skip same element to avoid duplicate quadruplets
      } else if (sum < targetSum)
        left++; // we need a pair with a bigger sum
      else
        right--; // we need a pair with a smaller sum
    }
  }

```
---

---
### Minimum Window that should be Sorted 
#### TC: O(N)  , MC: O(1)
- Scan from Left and Right and find pointer that are out of order.
- Find the Min and Max value in that Range
- Include the numbers that are greater than MIN and smaller than MAX
- [Back to Top](#Table-of-contents)
```java
public static int sort(int[] arr) {
    int low = 0, high = arr.length - 1;
    // find the first number out of sorting order from the beginning
    while (low < arr.length - 1 && arr[low] <= arr[low + 1])
      low++;

    if (low == arr.length - 1) // if the array is sorted
      return 0;

    // find the first number out of sorting order from the end
    while (high > 0 && arr[high] >= arr[high - 1])
      high--;

    // find the maximum and minimum of the subarray
    int subarrayMax = Integer.MIN_VALUE, subarrayMin = Integer.MAX_VALUE;
    for (int k = low; k <= high; k++) {
      subarrayMax = Math.max(subarrayMax, arr[k]);
      subarrayMin = Math.min(subarrayMin, arr[k]);
    }

    // extend the subarray to include any number which is bigger than the minimum of the subarray 
    while (low > 0 && arr[low - 1] > subarrayMin)
      low--;
    // extend the subarray to include any number which is smaller than the maximum of the subarray
    while (high < arr.length - 1 && arr[high + 1] < subarrayMax)
      high++;

    return high - low + 1;
  }
```
---



## Nth Smallest OR Largest
### Some
#### TC:  , MC:
- [Back to Top](#Table-of-contents)
```java

```
---

## Remove from Array
---
### Move All Zeros to the Beginning of the Array
#### TC: O(n) , MC: O(1)
- Read backwards, No Sorting required
- [Back to Top](#Table-of-contents)
```java
static void moveZerosToLeft(int[] nums) {
		// Return if the list is empty
		if (nums.length < 1) {
			return;
		}
		int numsLength = nums.length;

		// Initializing the two markers
		int nextNonZeroNumber = numsLength - 1;
		int readIndex = numsLength - 1;

		// Iterate read_index marker till the index is less than or equal to 0
		while (readIndex >= 0) {
			// Replacing write_index value with read_index value
			// This step moves the next non-zero value "back" in the array,
			// making space for the zero at the head of the array
			if (nums[readIndex] != 0) {
				nums[nextNonZeroNumber] = nums[readIndex];
                nextNonZeroNumber--;
			}
			readIndex--;
		}
		// Replacing initial values with zeroes
		while (nextNonZeroNumber >= 0) {
			nums[nextNonZeroNumber] = 0;
            nextNonZeroNumber--;
		}
	}
```
---
---

--- 
### Remove Duplicates
#### TC: O(NLogN)  , MC: O(1)
- Sort the Array, compute adjacent elements, update the nextNonDuplicateIndex  
- [Back to Top](#Table-of-contents)
```java
public static int remove(int[] arr) {
    Arrays.sort(arr);
    int nextNonDuplicate = 1; // index of the next non-duplicate element
    for (int i = 0; i < arr.length; i++) {
      if (arr[nextNonDuplicate - 1] != arr[i]) {
        arr[nextNonDuplicate] = arr[i];
        nextNonDuplicate++;
      }
    }

    return nextNonDuplicate;
  }
```
---
---

## Kadanes Algorithm
### Best Time to Buy and Sell Stock
#### TC: O(N)  , MC: O(1)
- Find the Global Minima , use that to compute MaxProfit.  
- [Back to Top](#Table-of-contents)
```java
public int maxProfit(int[] prices) {
        
        int maxProfit = Integer.MIN_VALUE; 
        int minPrice = Integer.MAX_VALUE; 
        
        
        for(int i = 0; i < prices.length; i ++)
        {
            minPrice = Integer.min(minPrice, prices[i]);
            maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
            
        }
        
        return maxProfit;
        
    }

```
---
### Maximum Subarray Kadane
#### TC: O(N) , MC: O(1)
- Maintain GlobalMaxSum and LocalRunningSum
- LocalRunningSum = max(LocalRunningSum + a[i], a[i])
- [Back to Top](#Table-of-contents)
```java
public int maxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        
        return maxSubarray;
    }

```
---






## DONE
- [Back to Top](#Table-of-contents)

## 











---
### Find Maximum in Sliding Window 
## TODO
- If an element is smaller than the one at the back of the queue,
  - then the index of this element is pushed in and becomes the new back.
- If the current element is larger,
  - then
    - 1.The back of the queue is popped repeatedly until we can find a higher value
    - 2.Then we’ll push the index of the current element in as the new back.

- The deque stores elements in decreasing order. The front of the deque contains the index for the maximum value in that particular window
- We will repeat the following steps each time our window moves to the right:
  - Remove the indices of all elements from the back of the deque, which are smaller than or equal to the current element.
  - If the element no longer falls in the current window, remove the index of the element from the front.
  - Push the current element index at the back of the window.
  - The index of the current maximum element is at the front.

```
public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
    ArrayDeque<Integer> result = new ArrayDeque<>(); // ArrayDeque for storing values
    Deque<Integer> list = new LinkedList<Integer>(); // creating a linked list
    if(arr.length > 0) {
      if( arr.length < windowSize) // Invalid State
        return result;
      for(int i = 0; i < windowSize; ++i) {
        // Removing last smallest element index
        while(!list.isEmpty() && arr[i] >= arr[list.peekLast()]){
          list.removeLast();      
        }
        // Adding newly picked element index
        list.addLast(i);
      }
      for(int i = windowSize; i < arr.length; ++i) {
        result.add(arr[list.peek()]);

        // Removing all the elements indexes which are not in the current window
        while((!list.isEmpty()) && list.peek() <= i-windowSize)
          list.removeFirst();
      // Removing the smaller elements indexes which are not required
        while((!list.isEmpty()) && arr[i] >= arr[list.peekLast()])
          list.removeLast();
        // Adding newly picked element index
        list.addLast(i);
      }
      // Adding the max number of the current window in the result
      result.add(arr[list.peek()]);
      return result; // returning result
    }
    else 
      return result;
  }
```
---


Two Dimensional Arrays#

### Merge Two Sorted Arrays
```// Merge arr1 and arr2 into resultantArray
  public static int[] mergeArrays(int[] arr1, int[] arr2) { 
    int s1 = arr1.length;
    int s2 = arr2.length;
    int[] resultantArray = new int[s1+s2];
    int i = 0, j = 0, k = 0;

    while (i < s1 && j < s2) { 
      if (arr1[i] < arr2[j]) 
        resultantArray[k++] = arr1[i++]; 
      else
        resultantArray[k++] = arr2[j++]; 
    } 
    while (i < s1) 
      resultantArray[k++] = arr1[i++]; 
    while (j < s2) 
      resultantArray[k++] = arr2[j++]; 
    return resultantArray;
  }
  ```
---
### Find Two Numbers that Add up to "n"
- Sorting the array
```
public static int[] findSum(int[] arr, int n) {
    Arrays.sort(arr);   
    int Pointer1 = 0;    //Pointer 1 -> At Start
    int Pointer2 = arr.length - 1;   //Pointer 2 -> At End
    int[] result = new int[2];
    int sum = 0;
    while (Pointer1 != Pointer2) {
      sum = arr[Pointer1] + arr[Pointer2];  //Calulate Sum of Pointer 1 and 2
      if (sum < n) 
        Pointer1++;  //if sum is less than given value => Move Pointer 1 to Right
      else if (sum > n) 
        Pointer2--; 
      else {
        result[0] = arr[Pointer1];
        result[1] = arr[Pointer2];
        return result; // containing 2 number 
      }
    }
    return arr; 
  } 
```
---
### Array of Products of All Elements Except Itself 
- Scan from Left and Right  
```
public static int[] findProduct(int arr[])  
  { 
    int n = arr.length;
    int i, temp = 1; 

    // Allocation of result array
    int result[] = new int[n]; 
    Arrays.fill(result, 1);

    // Product of elements on left side excluding arr[i]
    for (i = 0; i < n; i++)  
    { 
      result[i] *= temp; 
      temp *= arr[i]; 
    } 

    // Initializing temp to 1 for product on right side
    temp = 1; 

    // Product of elements on right side excluding arr[i] 
    for (i = n - 1; i >= 0; i--)  
    { 
      result[i] *= temp; 
      temp *= arr[i]; 
    }
    return result; 
  } 
```
---
### First Non-Repeating Integer in an Array
- Use a HashMap, below is an ArrayBased solution
```
public static int findFirstUnique(int[] arr) {
    //Inside Inner Loop Check Each index of outerLoop If it's repeated in array
    //If it's not repeated then return this as first unique Integer
    boolean isRepeated = false;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j] && i != j) {
          isRepeated = true;
          break;
        }
      } //end of InnerLoop
      if (isRepeated == false) {
        return arr[i];
      }
      else {
        isRepeated = false;
      }
    } //end of OuterLoop
    return - 1;
  }
```
---
### Find Second Maximum Value in an Array
- min = Integer.min(a[0], a[1]) and max = Integer.max(a[0], a[1])
```
public static int findSecondMaximum(int[] arr) {
    int max = Integer.MIN_VALUE;;
    int secondmax = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secondmax = max;
        max = arr[i];
      }
      else if (arr[i] > secondmax && arr[i] != max) {
        secondmax = arr[i];
      }
    }//end of for-loop

    return secondmax;
  } 
```
---
### Right Rotate the Array by One Index
- a[i] = a[i-1]  and a[0] = a[lastElement]
```
  public static void rotateArray(int[] arr) {
 int lastElement = arr[arr.length - 1];
    for (int i = arr.length - 1; i > 0; i--) {
      arr[i] = arr[i - 1];
    }

    arr[0] = lastElement;
  }  
```
---
### Re-arrange Positive & Negative Values
- Two pointer, nextNegativeNumber = 0 ; scanner will run from 0 to N-1
- Remove Duplicates, WhiteSpaces, etc
- End the string wit '\0'
```
public static void reArrange(int[] arr) 
  {
    int nextNegativeNumber = 0; 
    for (int scanner = 0; scanner < arr.length; scanner++) { 
      if (arr[scanner] < 0) {   // if negative number found
        if (scanner != nextNegativeNumber) { 
          int temp = arr[scanner];
          arr[scanner] = arr[nextNegativeNumber]; // swapping with leftmost positive
          arr[nextNegativeNumber] = temp;
        }
        nextNegativeNumber++; 
      } 
    } 
  } //end of reArrange()
```

---
### Move All Zeros to the Beginning of the Array
- Start from the last index , copy the elements that are required  
```
static void moveZerosToLeft(int[] A) {
    int nextNonZeroIndex = A.length -1 ;
    for (int runner = A.length -1 ; runner >= 0 ; runner --){
      if (A[runner] != 0){
          A[nextNonZeroIndex--] = A[runner];
      }
  }
 while (nextNonZeroIndex >=0){
    A[nextNonZeroIndex--] = 0;
  }
  }
```
---
### Rearrange Sorted Array in Max/Min Form
- Keep switching between large and small pointer for every iteration
```
public static void maxMin(int[] arr) {
    //Create a result array to hold re-arranged version of given arr
    int[] result = new int[arr.length];
    int pointerSmall = 0;     //PointerSmall => Start of arr
    int pointerLarge = arr.length - 1;   //PointerLarge => End of arr

    //Flag which will help in switching between two pointers
    boolean switchPointer = true;

    for (int i = 0; i < arr.length; i++) {
      if (switchPointer)
        result[i] = arr[pointerLarge--]; // copy large values
      else 
        result[i] = arr[pointerSmall++]; // copy small values
      switchPointer = !switchPointer;   // switching between samll and large
    } 
```
---
### Find the Sum of Maximum Sum Subarray
- Kadane Algo , localMax = a[0];
- localMax = MAX(a[i], LocalMax + a[i])
  - for i = 1 to N-1 
- GlobalMax = MAX(GlobalMax, localMax)
```
static int maxSubArraySum(int a[], int size)
    {
    int max_so_far = a[0];
    int curr_max = a[0];
 
    for (int i = 1; i < size; i++)
    {
           curr_max = Math.max(a[i], curr_max+a[i]);
        max_so_far = Math.max(max_so_far, curr_max);
    }
    return max_so_far;
    }
```
---
---
### Best time to Buy and Sell Stocks
- Get the Global min(current(i), min)
- Get the Global maxprofit( maxProfit, a[i] - min)

```
  public int maxProfit(int[] prices) {
        
        int maxProfit = Integer.MIN_VALUE; 
        int minPrice = Integer.MAX_VALUE; 
        
        
        for(int i = 0; i < prices.length; i ++)
        {
            minPrice = Integer.min(minPrice, prices[i]);
            maxProfit = Integer.max(maxProfit, prices[i] - minPrice);
            
        }
        
        return maxProfit;
        
    }
```


## Search
### Binary Search on a Sorted Array
- Recursive
```
static int binarySearchRec(int[] a, int key, int low, int high) {
    if (low > high) {
      return -1;
    }

    int mid = low + ((high - low) / 2);
    if (a[mid] == key) {
      return mid;
    } else if (key < a[mid]) {
      return binarySearchRec(a, key, low, mid - 1);
    } else {
      return binarySearchRec(a, key, mid + 1, high);
    }
  }
```
- Iterative
```
static int binSearch(int[] A, int key) {
    int low = 0;
    int high = A.length -1;
   while (low <= high) {
      int mid = low + ((high - low) / 2);
      if (A[mid] == key) {
        return mid;
      }
      if (key < A[mid]) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return -1;
  }
```

---
### Search a Rotated Array
#### TC: O(log n) , MC:  O(1)
- Recursive , we have two sorted arrays search in them 
```
public static int binarySearch(int[] arr, int start, int end, int key) {
    // assuming all the keys are unique.
    if (start > end) {
      return -1;
    }
   int mid = start + (end - start) / 2;
    if (arr[mid] == key) {
       return mid;
    }
    if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
      return binarySearch(arr, start, mid - 1, key);
    }
    else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
      return binarySearch(arr, mid + 1, end, key);
    }
    else if (arr[end] <= arr[mid]) {
      return binarySearch(arr, mid + 1, end, key);
    }
    else if (arr[start] >= arr[mid]) {
      return binarySearch(arr, start, mid - 1, key);
    }
    return -1;
  }

  static int binarySearchRotated(int[] arr, int key) {
    return binarySearch(arr, 0, arr.length - 1, key);
  } 
```
---
### Search in Rotated Sorted Array 
#### TC: O(log n) , MC:  O(1)
- Iterative
```
static int binarySearchRotated(int[] arr, int key) {
    int start = 0;
    int mid = 0;
    int end = arr.length - 1;
    if (start > end)
      return -1;
    while (start <= end){
      mid = start + (end - start) / 2; 
     if (arr[mid] == key)
        return mid;
      if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start])
        end = mid - 1;
      else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end])
        start = mid + 1;
      else if (arr[start] <= arr[mid] && arr[mid] <= arr[end] && key > arr[end])
      start = mid + 1; 
      else if (arr[end] <= arr[mid])
        start = mid + 1;  
      else if (arr[start] >= arr[mid])
        end = mid - 1;
      else
        return -1;  
    }
    return -1;
  } 
```
---
---
### Find Low/High Index of a Key in a Sorted Array
#### TC: O(N logN) , MC: O(1)
- Do not compare on the key
  - if key > arr[mid]
    - then low = mid + 1
  -else high = mid -1
- At the end low Will point the lower bound
```
static int findLowIndex (List<Integer> arr, int key) {
    int low = 0;
    int high = arr.size() - 1;
    int mid = high / 2;
    while (low <= high) {
      int midElem = arr.get(mid);
      if (midElem < key) {
        low = mid + 1;
      }
      else {
      high = mid - 1;
      }
      mid = low + (high - low) / 2;
    }
    if (low < arr.size() && arr.get(low) == key) {
      return low;
    }
    return -1;
  }
 ```
``` 
static int findHighIndex(List<Integer> arr, int key) {
    int low = 0;
    int high = arr.size() - 1;
    int mid = high / 2;
    while (low <= high) {
      int midElem = arr.get(mid);
      if (midElem <= key) {
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
      mid = low + (high - low) / 2;
    }
    if(high == -1){
      return high;
    }
    if (high < arr.size() && arr.get(high) == key) {
      return high;
    }
    return -1;
  }  
```
---
## Two Arrays  

---

### Find the Smallest Common Number
#### TC: O(NlogN) , MC: O(1)
- some
```
static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
    int i = 0, j = 0, k = 0;

    while(i < arr1.length && j < arr2.length && k < arr3.length) {
    
      // Finding the smallest common number
      if(arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
        return arr1[i];
      }

      // Let's increment the iterator
      // for the smallest value.

      if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
       i++;
      }

      else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
       j++;
      }

      else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
       k++;
      }
    }
    return -1;
  } 
```
## Merging Arrays 

---

### Merge an Array With Overlapping Intervals
#### TC: O(n)  , MC: O(n)
- Hint: Sort the intervals and Initialize the interval with first entry.
- Compare a[i-1].end with a[i] start
  
```
class Pair {
	public int first;
	public int second;

	public Pair(int x, int y) {
		this.first = x;
		this.second = y;
	}
}
class MergeIntervals {
	static ArrayList<Pair> mergeIntervals(ArrayList<Pair> v) {
		// If the list is empty
		if (v == null || v.size() == 0) {
			return null;
		}
		ArrayList<Pair> result = new ArrayList<Pair>();
		// Adding pair in the result list
		result.add(new Pair(v.get(0).first, v.get(0).second));
		for (int i = 1; i < v.size(); i++) {
			// Getting the recent added pair in the result list
			Pair recentAddedPair = result.get(result.size() - 1);
			// Getting and initializing input pair
			int currStart = v.get(i).first;
			int currEnd = v.get(i).second;
			// Getting and initializing recently added pair from result list
			int prevEnd = recentAddedPair.second;

			// Overlapping condition
			if (prevEnd >= currStart) {
				recentAddedPair.second = Math.max(currEnd, prevEnd);
			}
			// No overlapping
			else {
				result.add(new Pair(currStart, currEnd));
			}
		}

		return result;
```
	}
---
### Smallest Subarray With a Greater Sum
#### TC: O(N) , MC: O(1) ,  Easy
- Have a start , currentWindow and minLength
  - while currentWindow >= Target
    - check min(minLength, end - start + 1)
  - Return minLength
```
public static int findMinSubArray(int S, int[] arr) {
    int start = 0; 
    int minWindowLength = Integer.MAX_VALUE;
    int currentWindowSum = 0;
    for (int end = 0; end < arr.length; end ++ ){
      currentWindowSum += arr[end];
      while( currentWindowSum >= S){
        minWindowLength = Integer.min(minWindowLength, end - start + 1);
        currentWindowSum -= arr[start];
        start ++;
      }
    }
    return (minWindowLength == Integer.MAX_VALUE) ? -1 : minWindowLength;
  } 
```
---

## Left Right Pointer
  - While loops are better for such problems where pointers should be
      incremented conditionally. 

---

### Square a sorted Array
#### TC: O(N)  , MC: O (N), Easy
- Initialize the two pointers at start and end and move towards the center.
  - While loops are better for such problems 
```
public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int squareIndex = arr.length -1 ;
    int left = 0, right = arr.length - 1;

    while (left < right){
      int rightSquare = arr[right] * arr[right];
      int leftSquare = arr[left] * arr[left];

      if(leftSquare > rightSquare){
        squares[squareIndex--] = leftSquare;
        left++;
      }else {
        squares[squareIndex--] = rightSquare;
        right--;
      }
    }  
    return squares;
  } 
```
---
### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---
### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---

### Some
#### TC:  , MC:
- some
```
some 
```
---


### Find the subsets that add to a number in an Array
[Video Link](https://www.youtube.com/watch?v=nqlNzOcnCfs)
- Use recursion and trees
  
  
  
  

