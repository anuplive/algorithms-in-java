# Topic
### Table of contents
=================
<!--ts-->
| Name               |                                                                                                                  |                                                                                                     |   |   |   |
|--------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|---|---|---|
| Heaps              | [Implementation](#Implementation)                                                                                | Heap O(log(n))  insert and delete, get O(1)                                                         |   |   |   |
| Sorting            | [Sort By Frequency of Character](#Sort-By-Frequency-of-Character)                                                | [Sort Vowels and Consonants](#Sort-Vowels-and-Consonants)                                           |   |   |   |
| Two Heap Problems  | [Find the Median of a Number Stream](https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4) | [Sliding Window Median](https://www.educative.io/courses/grokking-the-coding-interview/3Y9jm7XRrXO) |   |   |   |
| Single Heap        | [Sliding Window Max](#Sliding-Window-Max)                                                                        |                                                                                                     |   |   |   |
|                    |                                                                                                                  |                                                                                                     |   |   |   |

<!--te-->

## Two Heaps
### Find the Median of a Number Stream
#### TC: O(log N) , MC: O (N)
- [Grocking](https://www.educative.io/courses/grokking-the-coding-interview/3Yj2BmpyEy4)
- [Back to Top](#Table-of-contents)
```java
class MedianOfAStream {

    PriorityQueue<Integer> maxHeap; //containing first half of numbers
    PriorityQueue<Integer> minHeap; //containing second half of numbers

    public MedianOfAStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one 
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }
```
### Sliding Window Median
#### TC: O(N * K) , MC: O(K)
- Two Heap Problems 
- [Back to Top](#Table-of-contents)
```java
class SlidingWindowMedian {
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public double[] findSlidingWindowMedian(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
      if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
        maxHeap.add(nums[i]);
      } else {
        minHeap.add(nums[i]);
      }
      rebalanceHeaps();

      if (i - k + 1 >= 0) { // if we have at least 'k' elements in the sliding window
        // add the median to the the result array
        if (maxHeap.size() == minHeap.size()) {
          // we have even number of elements, take the average of middle two elements
          result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else { // because max-heap will have one more element than the min-heap
          result[i - k + 1] = maxHeap.peek();
        }

        // remove the element going out of the sliding window
        int elementToBeRemoved = nums[i - k + 1];
        if (elementToBeRemoved <= maxHeap.peek()) {
          maxHeap.remove(elementToBeRemoved);
        } else {
          minHeap.remove(elementToBeRemoved);
        }
        rebalanceHeaps();
      }
    }
    return result;
  }
  // At the end the max heap is larger in size by 1    
  private void rebalanceHeaps() {
    // either both the heaps will have equal number of elements or max-heap will have 
    // one more element than the min-heap
    if (maxHeap.size() > minHeap.size() + 1)
      minHeap.add(maxHeap.poll());
    else if (maxHeap.size() < minHeap.size())
      maxHeap.add(minHeap.poll());
  }
}
   
```
---
### Sliding Window Max
#### TC: NlogK  , MC:
- Maintaing a Heap 
- [Back to Top](#Table-of-contents)
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ret = new int[nums.length - k  + 1];
        int left = 0;
        int right = 0;
		// max heap that first sorts elements by value (descending) and by their index (ascending) for duplicates
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (a != b) ? Integer.compare(nums[b], nums[a]) : 
                                                            Integer.compare(a, b));
        // Offer all elements from the first window
		for (; right < k; right++) {
            maxHeap.offer(right);
        }
		// This is because of heap property
        ret[left++] = nums[maxHeap.peek()];
        while (right < nums.length) {
		    // Making sure that the heap top always is within the current window
            while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                maxHeap.poll();
            }
            maxHeap.offer(right);
            ret[left] = nums[maxHeap.peek()];
            left++;
            right++;
        }
        
        return ret;
    }
}
```



## Single Heap
### Sort By Frequency of Character
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
### Sort Vowels and Consonants
#### TC: O (NlogN) , MC: O ( N)
- Heap
- [Back to Top](#Table-of-contents)
```java
class Solution {   
String test = "This is a Sample" +
                    "test String that will be test String for this test";
            Set<Character> vSet = new HashSet<>();
            // Create a HashMap with index and diff
            Map<Integer, Integer> indexHash = new HashMap<>();
            ArrayList<String> inputArray = new ArrayList<>();
            vSet.add('a');vSet.add('e');vSet.add('i');vSet.add('o');vSet.add('u');
            int stringPosition = 0;
            for (String s : test.split("\\s")){
                char [] cArray = s.trim().toCharArray();
                int vCounter = 0;
                for (int i = 0; i < cArray.length; i ++){
                    if (vSet.contains(cArray[i]))
                        vCounter++;
                }
                inputArray.add(stringPosition, s.trim());
                indexHash.put(stringPosition ++, cArray.length-vCounter);
            }
            // populate the priority queue
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)-> (a.getValue() - b.getValue()));
            pq.addAll(indexHash.entrySet());

            while (!pq.isEmpty()){
                Map.Entry<Integer, Integer> entry = pq.poll();
                System.out.println(String.format("%s has a diff of %d", inputArray.get(entry.getKey()), entry.getValue()));
            }
}
```





