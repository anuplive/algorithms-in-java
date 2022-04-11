# Topic
### Table of Data Structures
=================
<!--ts-->
* Arrays
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/g7K8xgjRyyZ) 
  * [LeetCode](https://leetcode.com/problem-list/top-100-liked-questions/?topicSlugs=array&page=1)
---
* LinkedList
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/B12o76Zq1z2)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=linked-list)
---
* Strings
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/B1mNWlJxvnX)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=string)
---
* Stacks 
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/B6mP2lRBmkW)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=stack)
* Queue
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/B6mP2lRBmkW)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=queue)
---
* Trees
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/xopm7m0pEol)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=tree)
---
* Trie
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/JQ3qoVDO72o)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?topicSlugs=trie&page=1)
---
* Heaps
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/JQ5wl6N6RWP)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=heap-priority-queue)
---
* HashTables
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/YVwVlxR010K)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=hash-table)
---
* Graphs
  * [Grocking](https://www.educative.io/module/lesson/data-structures-in-java/YVwVlxR010K)
  * [leetCode](https://leetcode.com/problem-list/top-100-liked-questions/?page=1&topicSlugs=graph)
---
<!--te-->

# Topic
### Must Do Coding Problems  
=================
<!--ts-->
*[Leet Code](https://leetcode.com/problem-list/top-100-liked-questions/)
<!--te-->

# Patterns 
### Different Programming Styles
=================
<!--ts-->
* [Dynamic Programming](https://www.educative.io/module/lesson/dynamic-programming-patterns/g2q4PWK3jlD)
---
* [Recurssion](https://www.educative.io/module/lesson/recursion-in-java/q2WVWWwrLR3)
---
* [Sorting and Searching](https://www.educative.io/module/lesson/algorithms-in-java/YMEyz4Y0jmA)
---
* [Greedy Algorithms](https://www.educative.io/module/lesson/algorithms-in-java/B8LjzQqNnnW)
---
* [Divide and Conquer](https://www.educative.io/module/lesson/algorithms-in-java/mEmxX11Kw2n)
---
* [Graphs](https://www.educative.io/module/lesson/algorithms-in-java/RLNQMB3zr1q)

<!--te-->

# TUTORIALS 
### 
=================
<!--ts-->
* [GROCKING THE CODING INTERVIEW](https://www.educative.io/courses/grokking-the-coding-interview)
---
* [Object Oriented Design](https://www.educative.io/module/oop-design-interview)
---
* [System Design](https://www.educative.io/courses/grokking-the-system-design-interview/B8nMkqBWONo)
<!--te-->

# RunTimeComplexity
- [Back to Top](#Table-of-contents)
  Below are the Big O performance of common functions of different Java Collections.


List                 | Add  | Remove | Get  | Contains | Next | Data Structure
---------------------|------|--------|------|----------|------|---------------
ArrayList            | O(1) |  O(n)  | O(1) |   O(n)   | O(1) | Array
LinkedList           | O(1) |  O(1)  | O(n) |   O(n)   | O(1) | Linked List
CopyOnWriteArrayList | O(n) |  O(n)  | O(1) |   O(n)   | O(1) | Array



Set                   |    Add   |  Remove  | Contains |   Next   | Size | Data Structure
----------------------|----------|----------|----------|----------|------|-------------------------
HashSet               | O(1)     | O(1)     | O(1)     | O(h/n)   | O(1) | Hash Table
LinkedHashSet         | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Hash Table + Linked List
EnumSet               | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Bit Vector
TreeSet               | O(log n) | O(log n) | O(log n) | O(log n) | O(1) | Red-black tree
CopyOnWriteArraySet   | O(n)     | O(n)     | O(n)     | O(1)     | O(1) | Array
ConcurrentSkipListSet | O(log n) | O(log n) | O(log n) | O(1)     | O(n) | Skip List



Queue                   |  Offer   | Peak |   Poll   | Remove | Size | Data Structure
------------------------|----------|------|----------|--------|------|---------------
PriorityQueue           | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
LinkedList              | O(1)     | O(1) | O(1)     |  O(1)  | O(1) | Array
ArrayDequeue            | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Linked List
ConcurrentLinkedQueue   | O(1)     | O(1) | O(1)     |  O(n)  | O(n) | Linked List
ArrayBlockingQueue      | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Array
PriorirityBlockingQueue | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
SynchronousQueue        | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | None!
DelayQueue              | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
LinkedBlockingQueue     | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Linked List



Map                   |   Get    | ContainsKey |   Next   | Data Structure
----------------------|----------|-------------|----------|-------------------------
HashMap               | O(1)     |   O(1)      | O(h / n) | Hash Table
LinkedHashMap         | O(1)     |   O(1)      | O(1)     | Hash Table + Linked List
IdentityHashMap       | O(1)     |   O(1)      | O(h / n) | Array
WeakHashMap           | O(1)     |   O(1)      | O(h / n) | Hash Table
EnumMap               | O(1)     |   O(1)      | O(1)     | Array
TreeMap               | O(log n) |   O(log n)  | O(log n) | Red-black tree
ConcurrentHashMap     | O(1)     |   O(1)      | O(h / n) | Hash Tables
ConcurrentSkipListMap | O(log n) |   O(log n)  | O(1)     | Skip List


