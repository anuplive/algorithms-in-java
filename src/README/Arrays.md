# Arrays

## Table of contents
=================
<!--ts-->

| Label         |  Links____________________________        | Links___________________________ | Links___________________________ | Links___________________________ | Links___________________________ | Links___________________________ | 
| ------------- |:-------------:| -----:| -----:| -----:| -----:| -----:| 
| Conversion | [Conversions](#Conversions)      |    [NA] |
| Sort | [Sorting Array](#Sorting-Array)      | Insertion ___ Merge ___ Quick Sort ___ Cyclic ___ Custom Sorting |
| Searching | [Searching](#Searching)      |    BinarySearch___Rotated_Array___Matrix___Order_Agnoistic |
| Sliding Window| [Sliding Window](#Sliding-Window) | [Max in Sliding Window](https://leetcode.com/problems/sliding-window-maximum/discuss/1967108/Java-Simple-Solution-with-Max-Heap-and-Deque) | [Longest_Substring_After_Replacement](https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR) | [Longest Subarray with Ones after_Replacement](https://www.educative.io/courses/grokking-the-coding-interview/B6VypRxPolJ) |
|Sliding Window|[Longest Substring with Same Letters after Replacement](https://www.educative.io/courses/grokking-the-coding-interview/R8DVgjq78yR)|[Longest Subarray with Ones after Replacement](https://www.educative.io/courses/grokking-the-coding-interview/B6VypRxPolJ) | [Permutation in a String](https://www.educative.io/courses/grokking-the-coding-interview/N0o9QnPLKNv)  |
|Sliding Window| [String Anagrams](https://www.educative.io/courses/grokking-the-oding-interview/xl2g3vxrMq3) | [Smallest Window containing Substring](https://www.educative.io/courses/grokking-the-coding-interview/xoyL4q6ApNE) | [Words Concatenation](https://www.educative.io/courses/grokking-the-coding-interview/N8nMBvDQJ0m) |       
| Two Pointer| [Two Pointer](#Two-Pointer)   | [Pair with Target Sum](https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP)|  [Triplet Sum to Zero](https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r) |  [Triplet Sum Close to Target](https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA) |  [Triplets with Smaller Sum](https://www.educative.io/courses/grokking-the-coding-interview/mElknO5OKBO)  | 
|Two Pointer | [Subarrays with Product Less than a Target](https://www.educative.io/courses/grokking-the-coding-interview/RMV1GV1yPYz)|
| Two Pointer | [Remove from Array](#Remove-from-Array) | Duplicates, Whitespaces, Zeros, Squaring Array  | [Dutch National Flag Problem](https://www.educative.io/courses/grokking-the-coding-interview/RMBxV6jz6Q0) |
| Fast Slow Pointers|[LinkedList Cycle](https://www.educative.io/courses/grokking-the-coding-interview/N7rwVyAZl6D) |  [Start of LinkedList Cycle](https://www.educative.io/courses/grokking-the-coding-interview/N7pvEn86YrN) |  [Happy Number](https://www.educative.io/courses/grokking-the-coding-interview/39q3ZWq27jM)  | [Middle of the LinkedList](https://www.educative.io/courses/grokking-the-coding-interview/3j5GD3EQMGM) ||
|[Nth Smallest OR Largest](#Nth-Smallest-OR-Largest)||
|[Kadanes Algorithm](#Kadanes-Algorithm)|Maximum Sum Subarray |  Stocks Buy Sell|
|[Left Scan Right Scan](Left-Scan-Right-Scan)|
|[Two Arrays](#Two-Arrays)|
|[Merging Intervals](#Merging-Intervals)|
|[Permutations](#Permutations)| [Match Permutation of Pattern with a String](https://www.educative.io/courses/grokking-the-coding-interview/N0o9QnPLKNv) ||
| [Mathematical](#Mathematical) |  [isPrime ? ](https://leetcode.com/discuss/general-discussion/573063/how-to-efficiently-find-nth-prime-number) ___  [prime till Numbers](https://leetcode.com/problems/count-primes/discuss/1876693/sieve-of-eratosthenes) ___ | [Integer to Roman](https://leetcode.com/problems/integer-to-roman/discuss/1913854/Java-easy-understanding-solution) ___ [Roman to Integer](https://leetcode.com/problems/roman-to-integer/discuss/1914300/Java-most-easiest-solution) |
|Matrix| [Spiral Traversal](https://leetcode.com/problems/spiral-matrix/discuss/1973026/Easy-understandable-Java-Solution)||
|Matrix |DFS |[Search Cross Word](https://leetcode.com/problems/word-search/discuss/1897337/Java-or-Simple-Approach)| [Count Islands](https://leetcode.com/problems/number-of-islands/discuss/1954752/Java-3ms-DFS-Explanation-O(M-*-N))| 
|Matrix | DP |[Maximal Square in Matrix](https://leetcode.com/problems/maximal-square/discuss/1726028/brute-force-and-dp-solution-with-comments)|
|MATRIX | BFS | [Shortest Distance from All Buildings](https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76934/10ms-BFS-Java-solution-with-explanation) | [Rotting_Oranges](#Rotting_Oranges) |
|MATRIX | [TIC-TAC-TOE](https://leetcode.com/problems/design-tic-tac-toe/discuss/1720452/Easy-Understanding-Java-Solution) | [Winner of Tic Tac Toe ](https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/discuss/1690470/Java%3A-Easy-to-understand-Beats-100-with-detailed-comments.)|
|Matrix| [Search_a_2D_Matrix](#Search_a_2D_Matrix) ||
___
___
<!--te-->

## Handy Checks
[Back to Top](#Table-of-contents)
```java
int[] arr = new int[2];
Arrays.sort(arr);
Arrays.sort(arr, ((a, b) -> a -b));
Arrays.fill(arr, -1);
List<Integer> list = Arrays.asList(arr)
Integer[] arrInt = list.toArray(new Integer[list.size()]);
int [] arr = new int[]{1,2,3};
```



## Conversions
- [Back to Top](#Table-of-contents)
```java
Integer.parseInt(s) // String to int
Integer.valueOf(s) // String to Integer
String.valueOf(int) // Integer to String
new String(char []) // charArray to String
List to Array -> list.toArray(new String[list.size()]);
Array to List -> Arrays.asList(arr)
[array to list]: List<String> list = Arrays.asList(arr); //also  for example: Arrays.asList("first", "second");
```

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
#### Best Case Time Complexity: O(n*log n)
#### Worst Case Time Complexity: O(n*log n)
####  Average Time Complexity: O(n*log n)
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

---
### Custom Sorting Frequency Sort
#### TC: O(N∗logN), MC: O(N)
- Characters will be sorted by their frequency 
- [Back to Top](#Table-of-contents)
```java
public static String sortCharacterByFrequency(String str) {
    // find the frequency of each character
    Map<Character, Integer> characterFrequencyMap = new HashMap<>();
    for (char chr : str.toCharArray()) {
      characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
        (e1, e2) -> e2.getValue() - e1.getValue());

    // add all characters to the max heap
    maxHeap.addAll(characterFrequencyMap.entrySet());

    // build a string, appending the most occurring characters first
    StringBuilder sortedString = new StringBuilder(str.length());
    while (!maxHeap.isEmpty()) {
      Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i = 0; i < entry.getValue(); i++)
        sortedString.append(entry.getKey());
    }
    return sortedString.toString();
  }
```
---



## Searching
---
### Binary Search on a Sorted Array
#### TC:  , MC:
- Recursive
- [Back to Top](#Table-of-contents)
```java
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
---
- Iterative
- [Back to Top](#Table-of-contents)
```java
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
---
### Searching in a Rotated Sorted Array
#### TC: O(log n) , MC:  O(1)
- Recursive , we have two sorted arrays search in them
- [Back to Top](#Table-of-contents)
```java
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
- Iterative, we have two sorted arrays search in them
- [Back to Top](#Table-of-contents)
```java
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
### Search_a_2D_Matrix
#### TC: O(logmn)  , MC: O(1)
- The 2D array is represented as pivotted array
- 
- [Back to Top](#Table-of-contents)
```java
public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement)
                    right = pivotIdx - 1;
                else
                    left = pivotIdx + 1;
            }
        }
        return false;
    }

```
---

---
### Order-agnostic Binary Search
#### TC: O(logN) , MC: O(1)
- Some comment
- [Back to Top](#Table-of-contents)
```java
public static int search(int[] arr, int key) {
    int start = 0, end = arr.length - 1;
    boolean isAscending = arr[start] < arr[end];
    while (start <= end) {
      // calculate the middle of the current range
      int mid = start + (end - start) / 2;

      if (key == arr[mid])
        return mid;

      if (isAscending) { // ascending order
        if (key < arr[mid]) {
          end = mid - 1; // the 'key' can be in the first half
        } else { // key > arr[mid]
          start = mid + 1; // the 'key' can be in the second half
        }
      } else { // descending order        
        if (key > arr[mid]) {
          end = mid - 1; // the 'key' can be in the first half
        } else { // key < arr[mid]
          start = mid + 1; // the 'key' can be in the second half
        }
      }
    }
    return -1; // element not found
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
		Deque<Integer> indexList = new ArrayDeque<Integer>(); // creating a linked list

		if (arr.length > 0) {
			// If window_size is greater than the array size,
			// set the window_size to nums.size()
			if (arr.length < windowSize)
				windowSize = arr.length;
            // Populate the window 
			for (int i = 0; i < windowSize; ++i) {
				// Removing last smallest element index
				while (!indexList.isEmpty() && arr[i] >= arr[indexList.peekLast()]) {
                 indexList.removeLast();
				}
				// Adding newly picked element index
                indexList.addLast(i);
			}

			for (int i = windowSize; i < arr.length; ++i) {
				result.add(arr[indexList.peek()]);

				// Removing all the elements indexes which are not in the current window
				while ((!indexList.isEmpty()) && list.peek() <= i - windowSize)
                      indexList.removeFirst();

				// Removing the smaller elements indexes which are not required
				while ((!indexList.isEmpty()) && arr[i] >= arr[indexList.peekLast()])
                    indexList.removeLast();

				// Adding newly picked element index
                  indexList.addLast(i);
			}

			// Adding the max number of the current window in the result
			result.add(arr[indexList.peek()]);
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
public void sortColors(int[] nums) {

    // Set the boundries for the 0 and the 2, and start iterating from 0 
        int nextZeroIndex = 0 , nextTwoIndex = nums.length -1;
        int curr = 0;

        int temp = 0;
    // Boundry condition     
        while(curr <= nextTwoIndex){
    
    // If ==0 then swap increment both Indices        
        if (nums[curr] == 0){
        temp = nums[nextZeroIndex];
        nums[nextZeroIndex ++] = nums[curr];
        nums[curr++] = temp;
        
    // If ==2 decrement only the right Indices
        }else if (nums[curr] == 2){
        temp = nums[nextTwoIndex];
        nums[nextTwoIndex --] = nums[curr];
        nums[curr] = temp;

        }else {
        curr ++;
        }
        }
 }
```
---

---
### Rearrange Sorted Array in Max/Min Form
#### TC:  , MC:
- Keep switching between large and small pointer for every iteration
- [Back to Top](#Table-of-contents)
```java
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

## Remove from Array
- Two pointer, nextNegativeNumber = 0 ; scanner will run from 0 to N-1
- Remove Duplicates, WhiteSpaces, etc
- End the string wit '\0'

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
### Re-arrange Positive & Negative Values
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
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



---

## Nth Smallest OR Largest
---
---
### Find Second Maximum Value in an Array
#### TC: O(N) , MC: O(1)
- min = Integer.min(a[0], a[1]) and max = Integer.max(a[0], a[1])
- [Back to Top](#Table-of-contents)
```java
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

---
### Kth Largest Element in an Array
#### TC: O(Nlogk) , MC: O(K)
- PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);
- [Back to Top](#Table-of-contents)
```java
public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // output
        return heap.poll();        
  }
}

```
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

---
## Left Scan Right Scan
---
### Array of Products of All Elements Except Itself
#### TC: O(N) , MC: O(1)
- Some comment
- [Back to Top](#Table-of-contents)
```java
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

## Two Arrays
---
### Find the Smallest Common Number in Sorted Arrays 
#### TC:  , MC:
- If Arrays are not Sorted Sort them 
- [Back to Top](#Table-of-contents)
```java
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
---

## Merging Intervals
---
### Merge an Array With Overlapping Intervals
#### TC:  , MC:
- Hint: Sort the intervals and Initialize the interval with first entry.
- Compare a[i-1].end with a[i] start
- [Back to Top](#Table-of-contents)
```java
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
---
---
### Conflicting Appointments
#### TC: O (NLogN)  , MC: O(N)
- sort the intervals by start time
- [Back to Top](#Table-of-contents)
```java
class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class ConflictingAppointments {

  public static boolean canAttendAllAppointments(Interval[] intervals) {
    // sort the intervals by start time
    Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

    // find any overlapping appointment
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i].start < intervals[i - 1].end) {
        // please note the comparison above, it is "<" and not "<="
        // while merging we needed "<=" comparison, as we will be merging the two
        // intervals having condition "intervals[i].start == intervals[i - 1].end" but
        // such intervals don't represent conflicting appointments as one starts right
        // after the other
        return false;
      }
    }
    return true;
  }
```
---
---
### Minimum Meeting Rooms
#### TC:  , MC:
- Sort using Comparator, then call iterator over the List
- [Back to Top](#Table-of-contents)
```java
class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class MinimumMeetingRooms {

  public static int findMinimumMeetingRooms(List<Meeting> meetings) {

    Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));
    Iterator<Meeting> itr = meetings.iterator();
    int rooms = 1;
    Meeting m = itr.next();
    int start = m.start;
    int end = m.end;
    int prevEnd = m.end;

    while(itr.hasNext()){
      Meeting meet =  itr.next();
      int s = meet.start;
      int e = meet.end;

      if (s < end ){
        if (rooms > 1){
            if (s < prevEnd)
              rooms += 1;
            else   
              rooms += 1;
        }      
        prevEnd = Math.min(end, e );
        end = Math.max(end, e );
      }
      else {
        start = s;
        prevEnd = Math.min(end, e);
        end = e;
      }

      return rooms;  

    }  
```
---

## Permutations
---
### Generate all the possible permutations
#### TC: O(N∗N!), MC: O(N∗N!)
- Some comment
- [Back to Top](#Table-of-contents)
```java
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        perm(result, nums, 0, nums.length - 1);
        return result;
    }

    public void perm(List<List<Integer>> result, int[] nums, int start, int end) {
        if (start >= end) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        } else {
            for (int i = start; i <= end; i++) {
                swap(nums, start, i);
                perm(result, nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

```
---


---
## Matrix
### Rotting_Oranges
#### TC:  , MC:
- BFS Search
- [Back to Top](#Table-of-contents)
```java
class Solution {
    public int orangesRotting(int[][] mat) {
        
		Queue<int[]> q = new LinkedList<>();  //queue of arr to store {i,q} position of roton orange
       
	   int freshCount = 0;     //to count all fresh oranges
        int m = mat.length;    //rows count to run loop 
        int n = mat[0].length; //cols count to run loop
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){    //iterate over matrix
               if(mat[i][j]==1){
                    freshCount++;   //count all fresh oranges present
                }
                else if(mat[i][j]==2){
                    q.add(new int[] {i,j});  //add {i,q} position of rooten oranges in queue
                }
            }
        }
        
        int minutes = 0;  //minutes which we have to return if all oranges rotten
        
        int[][] dirs = {     //Matrix of coordinate to which rotten orange can spread rotteness
            { 0, 1}, //right
            { 0,-1}, //left
            {-1, 0}, //up
            { 1, 0}  //down
        };
        
        while(!q.isEmpty()){  //if queue is not empty rotten oranges is present in queue
            int size = q.size();  //size count to runn a loop to chech adjecent of each rotten orange present in queue
            for(int i=0;i<size;i++){  //check for adjecent fresh oranges of rotten orange
                int[] curr = q.poll();  //remove rot orange from queue & consider as current orange
                for(int[] arr: dirs){  //for each arr in dirs mat
                    int x = curr[0]+arr[0];  //add possible rotten coordinate to curr cordinate
                    int y = curr[1]+arr[1];  //for checking all direction of rotten orange
                    
                    if(x<0 || y<0 || x>=m || y>=n || mat[x][y]==2 || mat[x][y]==0){  
                        continue;  //skip outOfBound & already rotten & empty cell
                    }
                    else{  //if fresh orange found in adjecent of rotten orange
                        mat[x][y] = 2; //make it rotten
                        freshCount--;  //reduce the no of fresh count
                        q.add(new int[] {x,y}); //add this rotten orange in queue
                    }
                }
            }
            
            if(!q.isEmpty()){  //if fresh oranges rot and added to queue means minutes++
                minutes++;
            }
        }
        
        if(freshCount==0){ //if no fresh orange remains return minutes
            return minutes;
        }
        return -1; // else return -1 if some fresh oranges remain
    }
}

```
---







## DONE
- [Back to Top](#Table-of-contents)
---



### Find the subsets that add to a number in an Array
[Video Link](https://www.youtube.com/watch?v=nqlNzOcnCfs)
- Use recursion and trees
  
  
  
  

