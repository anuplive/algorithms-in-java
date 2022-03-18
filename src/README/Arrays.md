# Arrays

Table of contents
=================
<!--ts-->
* [Sliding Window](#Sliding-Window)
* [Sorting Array](#Sorting-Array)
<!--te-->


### Find the subsets that add to a number in an Array 
[Video Link](https://www.youtube.com/watch?v=nqlNzOcnCfs)
- Use recursion and trees



## Sliding Window
---
### Maximum Sum Subarray of Size K
#### TC: O(N)  , MC: O(1), Easy
- Hint: Have a start pointer, and a currentWindowSum
  - Iterate through the array
    - Keep adding to the currentSum
      - If the iterator value > Size K , then currentSum -= array[start++]
    - compare the currentSum with globalMax Sum 
```
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
## Sorting Array  
---
### Sort an Array Using Quicksort Algorithm
#### TC: O(NlogN)  , MC: O(logN)
- Recursive Algo has three parts
  - partition: divides the array at pivot
  - quickSortRec: Recursively calls the Quick Sort
  - quickSort: Initializes the algo
```
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
```
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


  
  
  
  

