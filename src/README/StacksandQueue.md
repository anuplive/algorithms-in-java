# Stacks and Queue

### Table of contents
=================
<!--ts-->
* [Stack and Queue Intro](#Stack_and_Queue_Intro)
  * [Common Stack and Queue Methods](#Common_Stack_and_Queue_Methods)
  * [Stack Implementation](#Stack_Implementation)
  * [Queue Implementation](#Queue_Implementation)
  * [DeQueue Implementation](#DeQueue_Implementation)
  * [Implementing Queue using Stack](#Implementing_Queue_using_Stack)
  * [Implementing Stack using Queue](#Implementing_Stack_using_Queue)
  * [Generate_Binary_Numbers_using_Queue](#Generate_Binary_Numbers_using_Queue)
  * [Implementing_Two_Stack_Using_Array](#Implementing_Two_Stack_Using_Array)
  * [Implementing_Stack_Using_Queue](#Implementing_Stack_Using_Queue)
  * [Generate_Binary_Numbers_using_Queue](#Generate_Binary_Numbers_using_Queue)
  * [Implementing_Two_Stack_Using_Array](#Implementing_Two_Stack_Using_Array)
  * [Reverse_first_K_elements_in_Queue](#Reverse_first_K_elements_in_Queue)
  * [Sort_Using_Stack](#Sort_Using_Stack)
  * [Postfix Expression Stack](#Postfix_Expression_Stack)
  * [Next_Greater_Element_Stack](#Next_Greater_Element_Stack)
  * [Find_Celebrity_using_Stack](#Find_Celebrity_using_Stack)
  * [Balanced_Parenthesis](#Balanced_Parenthesis)
  * [Implement_a_MinStack](#Implement_a_MinStack)
  * [Binary_Tree_Iteration](#Binary_Tree_Iteration)
  * []
  
* [Heading 2](#Heading-2)
* [Priority Queue](#Priority-Queue)

<!--te-->

## Stack and Queue Intro
---
### Common Stack and Queue Methods
- [Back to Top](#Table-of-contents)
```java
        // Stack
        Stack<Person> pStack = new Stack<Person>();
        pStack.pop(); pStack.push(new Person(10, "Anup")); pStack.peek();
        
        pStack.size(); pStack.isEmpty();
        
        //ListIterator();
        ListIterator<Person> pStackList = pStack.listIterator();
        while(pStackList.hasNext()){
            System.out.println(pStackList.next().name);
        }
        
        // Queue and LinkedList
        // Singly Linked list vs Doubly Linked list in Java
        List<Person> sll = new LinkedList<>();
        sll.get(10);
        LinkedList<Person> dll = new LinkedList<>();
        dll.getFirst(); dll.getLast();

        // Normal queue created using a Linked List
        Queue<Person> pq = new LinkedList<>();
        pq.poll(); pq.offer(new Person(10,"Anup")); pq.peek();

        pq.isEmpty(); pq.size();

        Iterator<Person> pi = pq.iterator();
        while(pi.hasNext()){System.out.println(pi.next());}

        // Double Ended Queue still created using a Linked List
        Deque<Person> dq = new LinkedList<>();
        dq.offerFirst(new Person(10, "Anup")); dq.offerLast(new Person(11, "Kumar")); // offer
        dq.peekFirst();dq.peekLast(); // like peek
        dq.pollFirst(); dq.pollLast();// poll
        
        
        
```
---

### Stack Implementation
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
class Person{
    int age;
    String name;
    Person(int i, String n){
        this.age = i;
        this.name = n;
    }
}

class MyStack<E>{
    public static final int DEFAULT_CAPACITY = 10;
    E [] stackArray;
    int top;
    int capacity;
    @SuppressWarnings("unchecked")
    MyStack(int cap){
        this.stackArray =  (E[]) new Object[cap]; // Very important unsafe type casting
        this.top = -1;
        this.capacity = cap;
    }
    @SuppressWarnings("unchecked")
    MyStack(){
        this.stackArray = (E[]) new Object[DEFAULT_CAPACITY];
        this.top = -1;
        this.capacity = DEFAULT_CAPACITY;
    }

    public E pop(){
        if(isEmpty())
            return null;
        else
            return (E) this.stackArray[top--];
    }

    public void push(E item){
        if(isFull())
        {
            System.out.println("Stack is full");
            return;
        }
        this.stackArray[++top] = item;
    }

    public E peek(){
        if(isEmpty())
            return null;
        return stackArray[top];
    }

    public Boolean isEmpty(){
        return this.top == -1;
    }

    public Boolean isFull(){
        return this.top == (capacity -1);
    }
    public int size(){
        return capacity;
    }

}

```
---

### Queue Implementation
#### TC:  , MC:
- This is a Circular Queue implementation
- [Back to Top](#Table-of-contents)
```java
class Person{
    int age;
    String name;
    Person(int i, String n){
        this.age = i;
        this.name = n;
    }
}

class MyQueue<E>{
    public static final int DEFAULT_CAPACITY = 10 ;
    E [] queueArray;
    int capacity;
    int front;
    int back;
    int currentSize;

    @SuppressWarnings("unchecked")
    MyQueue(int cap){
        this.queueArray = (E[]) new Object[cap];
        this.capacity = cap;
        this.front = 0;
        this.back = -1;
        this.currentSize = 0;
    }
    @SuppressWarnings("unchceked")
    MyQueue(){
        this.queueArray = (E[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.front = 0;
        this.back = -1;
        this.currentSize = 0;
    }

    public boolean isEmpty(){
            return (currentSize == 0);
    }
    public boolean isFull(){
        return ( currentSize + 1 == capacity);
    }

    public int size(){
        return capacity;
    }

    public E peek(){
        if (isEmpty())
            return null;
        return queueArray[front];
     }

    public E poll(){
        if (isEmpty())
            return null;
        E temp = queueArray[front];
        front = (front + 1) % capacity; // Wrapping the index range back to the limits
        currentSize --;
        return temp;
    }

    public void offer(E item){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        back = (back + 1) % capacity; // Making sure the capacity is within the range
        currentSize ++;
        queueArray[back] = item;
    }
}

```
---

### DeQueue Implementation
#### TC:  , MC:
- Check the wrap arround confitions for OfferFirst and PoolLast
- [Back to Top](#Table-of-contents)
```java
class Person{
    int age;
    String name;
    Person(int i, String n){
        this.age = i;
        this.name = n;
    }
}
class MyDeque<E>{
    public static final int DEFAULT_CAPACITY = 10 ;
    E [] queueArray;
    int capacity;
    int front;
    int back;
    int currentSize;

    @SuppressWarnings("unchecked")
    MyDeque(int cap){
        this.queueArray = (E[]) new Object[cap];
        this.capacity = cap;
        this.front = 0;
        this.back = -1;
        this.currentSize = 0;
    }
    @SuppressWarnings("unchceked")
    MyDeque(){
        this.queueArray = (E[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.front = 0;
        this.back = -1;
        this.currentSize = 0;
    }

    public boolean isEmpty(){
        return (currentSize == 0);
    }
    public boolean isFull(){
        return ( currentSize + 1 == capacity);
    }
    public int size(){
        return currentSize;
    }

    public E peek(){
        if (isEmpty())
            return null;
        return queueArray[front];
    }
    public E peekFirst(){
        if (isEmpty())
            return null;
        return queueArray[front];
    }
    public E peekLast(){
        if (isEmpty())
            return null;
        return queueArray[back];
    }



    public E poll(){
        if (isEmpty())
            return null;
        E temp = queueArray[front];
        front = (front + 1) % capacity; // Wrapping the index range back to the limits
        currentSize --;
        return temp;
    }
    public E pollFirst(){
        if (isEmpty())
            return null;
        E temp = queueArray[front];
        front = (front + 1) % capacity; // Wrapping the index range back to the limits
        currentSize --;
        return temp;
    }
    public E pollLast(){
        if (isEmpty())
            return null;
        E temp = queueArray[back];
        if (back == 0)
            back = capacity -1 ;
        else 
            back = back -1; 
        currentSize --;
        return temp;
    }

    public void offer(E item){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        back = (back + 1) % capacity; // Making sure the capacity is within the range
        currentSize ++;
        queueArray[back] = item;
    }
    public void offerLast(E item){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        back = (back + 1) % capacity; // Making sure the capacity is within the range
        currentSize ++;
        queueArray[back] = item;
    }
    public void offerFirst(E item){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        
        if (front == 0)
            front = capacity -1 ;
        else 
            front = front - 1; 
        currentSize ++;
        queueArray[front] = item;
    }
}

```
---

### Implementing Queue using Stack
#### deque: O(N), enqueue = O(1) , MC: O(N)
- Slow dequeue, fast enque 
- [Back to Top](#Table-of-contents)
```java
class QueueUsingStack {
    
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	void enqueue(int data) {
		stack1.push(data);
	}

	// Uses the default size() method of the stack class
	// to check if the queue is empty
	boolean isEmpty() {
		return stack1.size() + stack2.size() == 0;
	}

	int dequeue() {
		if (isEmpty()) {
			return -1;
		}

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				// Pop values from stack1 and push them
				// onto stack2
				stack2.push(stack1.pop());
			}
		}

		// Pop the last value and return it
		return stack2.pop();
	}
}

```
---
#### enqueue: O(N), Dequeue = O(1) , MC: O(N)
- Faster Deque, slow enqueue
- [Back to Top](#Table-of-contents)
```java
class QueueUsingStack {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  void enqueue(int data) {
    while (!stack1.isEmpty()) {
      // Pop values from stack1 and push them
      // onto stack2
      stack2.push(stack1.pop());
    }

    stack1.push(data);

    while (!stack2.isEmpty()) {
      stack1.push(stack2.pop());
    }
  }

  // Uses the default size() method of the stack class
  // to check if the queue is empty
  boolean isEmpty() {
    return stack1.size() + stack2.size() == 0;
  }


  int dequeue() {
    if (isEmpty()) {
      return -1;
    }

    return stack1.pop();
  }
  public static void main(String[] args) {}}
```
---

---

### Implementing_Stack_Using_Queue
#### TC: Push : O(1) and Pop : O(N) 
- Fast Push, slow pop()
- [Back to Top](#Table-of-contents)
```java
class StackUsingQueue {
	Queue<Integer> queue1 = new ArrayDeque<Integer>();
	Queue<Integer> queue2 = new ArrayDeque<Integer>();

	void push(int data) {
		queue1.add(data);
	}

	// Uses the default size() method of the queue class
	// to check if the stack is empty
	boolean isEmpty() {
		return queue1.size() + queue2.size() == 0;
	}

	// Helper function that swaps our queues using a temp queue
	void swapQueues() {
		Queue<Integer> queue3 = queue1;
		queue1 = queue2;
		queue2 = queue3;
	}

	int pop() {
		if (isEmpty()) {
			return -1;
		}

		while (queue1.size() > 1) {
			queue2.add(queue1.remove());
		}

		// When there is only 1 value in queue1, pop() it
		// and swap the queues
		int value = queue1.remove();
		swapQueues();
		return value;
	}}
```
---
#### TC: Slow Push : O(N) and Fast Pop : O(1)
- Slow Push, Fast pop()
- [Back to Top](#Table-of-contents)
```java
import java.util.*;

class StackUsingQueue {
  Queue<Integer> queue1 = new ArrayDeque<Integer>();
  Queue<Integer> queue2 = new ArrayDeque<Integer>();

  void push(int data) {
    if (queue1.isEmpty()) {
      queue1.add(data);
    } else {
      queue2.add(data);
      while (!queue1.isEmpty()) {
        // Dequeue values from queue1 and enqueue them
        // onto queue2
        queue2.add(queue1.remove());
      }
      // queue2 now has all the elements in the correct order
      swapQueues();
    }
  }

  // Uses the default size() method of the queue class
  // to check if the stack is empty
  boolean isEmpty() {
    return queue1.size() + queue2.size() == 0;
  }

  // Helper function that swaps our queues using a temp
  // queue pointer
  void swapQueues() {
    Queue<Integer> queue3 = queue1;
    queue1 = queue2;
    queue2 = queue3;
  }

  int pop() {
    if (isEmpty()) {
      return -1;
    }
    return queue1.remove();
  }

  public static void main(String[] args) {
    StackUsingQueue sq = new StackUsingQueue();
  }}
```
---

### Generate_Binary_Numbers_using_Queue
#### TC:  O (N), SC: 
- **Theme** 
- Take element -> do some operation -> push in queue
- take the front element in Queue -> do some operation ->  push in queue again. 
- [Back to Top](#Table-of-contents)
```java
class CheckBinary {
    //1.Start with Enqueuing 1.
    //2.Dequeue a number from queue and append 0 to it and enqueue it back to queue.
    //3.Perform step 2 but with appending 1 to the original number and enqueue back to queue.
    //Size of Queue should be 1 more than number because for a single number we're enqueuing two
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<String>(number + 1);

        queue.enqueue("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.dequeue();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.enqueue(s1);
            queue.enqueue(s2);
        }

        return result; //For number = 3 , result = {"1","10","11"};
    }}
```

---

### Implementing_Two_Stack_Using_Array  
#### TC: O(1) , 
- Take the array maintain two tops of stack at both ends
- [Back to Top](#Table-of-contents)
```java
//You can either divide array in two halves or start stacks at extreme ends.
//We'll use the second technique to solve this problem.
//Top of Stack 1 start from extreme left of array i.e top1 = 0;
//Top of Stack 2 start from extreme right of array i.e top2 = size - 1
public class TwoStacks<V> {
    private int maxSize;
    private int top1, top2; //Store top value indices of Stack 1 and Stack 2
    private V[] array;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        this.top1 = -1;
        this.top2 = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    //insert at top of first stack
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        }
    }

    //insert at top of second stack
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (top2 < maxSize) {
            return array[top2++];
        }
        return null;
    }
}


```
---

### Reverse_first_K_elements_in_Queue 
#### TC: O(N) ,
- Notes: Use a Stack, add first K elements in queue
- Pop the elements from stack and add them in queue
- Then dequeue the queue till kth element and again enqueue in same queue. 
- [Back to Top](#Table-of-contents)
```java
class CheckReverse {

    //1.Push first k elements in queue in a stack.
    //2.Pop Stack elements and enqueue them at the end of queue
    //3.Dequeue queue elements till "k" and append them at the end of queue   
    //4.Dequeue the remaining elements and enqueue them again to append them at end of the queue
    public static <V> void reverseK(Queue<V> queue, int k) {
        if (queue.isEmpty() || k <= 0)
            return;
        Stack<V> stack = new Stack<>(k);

        while(!stack.isFull())
            stack.push(queue.dequeue());

        while(!stack.isEmpty())
            queue.enqueue(stack.pop());

        int size = queue.getCurrentSize();
        for(int i = 0; i < size - k; i++)
            queue.enqueue(queue.dequeue());
    }
    public static void main(String args[]) {

        Queue<Integer> queue = new Queue<Integer>(10);
    }}

```
---

### Sort_Using_Stack
#### TC: O(n^2)
-  //1. Use a second tempStack.
-  //2. Pop value from mainStack.
-  //3. If the value is greater or equal to the top of tempStack, then push the value in tempStack
   //else pop all values from tempStack and push them in mainStack and in the end push value in tempStack and repeat from step 2.
   //till mainStack is not empty.
-  //4. When mainStack will be empty, tempStack will have sorted values in descending order.
-  //5. Now transfer values from tempStack to mainStack to make values sorted in ascending order.
- [Back to Top](#Table-of-contents)
```java
class CheckSort {
    public static void sortStack(Stack<Integer> stack) {
       
        Stack<Integer> newStack = new Stack<>(stack.getMaxSize());
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            if (!newStack.isEmpty() && value >= newStack.top()) {
                newStack.push(value);
            } else {
                while (!newStack.isEmpty() && newStack.top() > value)
                    stack.push(newStack.pop());
                newStack.push(value);
            }
        }
        while (!newStack.isEmpty())
            stack.push(newStack.pop());
    }
    public static void main(String args[]) {
    }
}
```
---

### Postfix_Expression_Stack
#### TC: O(n),
- //1.Scan expression character by character,
- //2.If character is a number push it in stack
- //3.If character is operator then pop two elements from stack
- //perform the operation and put the result back in stack
- //At the end, Stack will contain result of whole expression.
- [Back to Top](#Table-of-contents)
```java
class EvaluatePostfixChallenge {
    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (!Character.isDigit(character)) {
                Integer x = stack.pop();
                Integer y = stack.pop();

                switch (character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }

            } else
                stack.push(Character.getNumericValue(character));
        }
        return stack.pop();
    }
	public static void main(String args[]) {
	
		System.out.println(evaluatePostFix("921*-8-4+"));
		//Try your own examples belo
 }
}
```
---

### Next_Greater_Element_Stack 
#### TC:  ,
- iterate from last
  - stack.pop() elements from stack if arr[i] > stack.top()
  - If Stack empty ?, result[i] = -1
        else result[i] = stack.top()
  - 3. stack.push(arr[i])

- [Back to Top](#Table-of-contents)
```java
class NextGreaterChallenge {
  public static int[] nextGreaterElement(int[] arr) {
    int[] result = new int[arr.length];
    int resultIndex = 0;
    Stack<Integer> stack = new Stack<>(arr.length);
    // iterate for rest of the elements
    for (int i = arr.length - 1; i >= 0; i--) {
      if (!stack.isEmpty()) {
        while (!stack.isEmpty() && stack.top() <= arr[i]) {
          stack.pop();
        }
      }
      if(stack.isEmpty()){
        result[i] = -1;
      }
      else
        result[i]  = stack.top();
      stack.push(arr[i]);
    }
    return result;
  }

  public static void main(String[] args)
  {}
}

```
---

### Find_Celebrity_using_Stack
#### TC:   ,
- pop two elements, push one back to stack 
- [Back to Top](#Table-of-contents)
```java
class FindCelebChallenge {
   //returns true if x knows y else returns false
    private static boolean aqStatus(int[][] party, int x, int y) {
        if (party[x][y] == 1) return true;
        return false;
    }

    public static int findCelebrity(int[][] party, int numPeople) {
        Stack<Integer> stack = new Stack<>(numPeople);
        int celebrity = -1;

        //Push all people in stack
        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {

            //Take two people out of stack and check if they know each other
            //One who doesn't know the other, push it back in stack.
            int x = stack.pop();

            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }

            int y = stack.pop();

            if (aqStatus(party, x, y)) {
                //x knows y , discard x and push y in stack
                stack.push(y);
            } else stack.push(x);

        } //end of while

        //At this point we will have last element of stack as celebrity
        //Check it to make sure it's the right celebrity
        for (int j = 0; j < numPeople; j++) {

            //Celebrity knows no one while everyone knows celebrity
            if (celebrity != j && (aqStatus(party, celebrity, j) || !(aqStatus(party, j, celebrity)))) return -1;
        }
        return celebrity;
    }//end of findCelebrity()

    public static void main(String args[]) {
        
        int [][] party1 = {
          {0,1,1,0},
          {1,0,1,1},
          {0,0,0,0},
          {0,1,1,0},   
        };
    }}
```
---

### Balanced_Parenthesis
#### TC:   ,
- Notes
- [Back to Top](#Table-of-contents)
```java
class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {

        //Iterate through the string exp.
        //For each opening parentheses, push it into stack
        //For every closing parenthesis check for its opening parentheses in stack
        //If you can't find the opening parentheses for any closing one then returns false.
        //and after complete traversal of string exp, if there's any opening parentheses left
        //in stack then also return false.
        //At the end return true if you haven't encountered any of the above false conditions.
        Stack<Character> stack = new Stack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {

            char character = exp.charAt(i);

            if (character == '}' || character == ')' || character == ']') {

                if (stack.isEmpty()) return false;

                if ((character == '}' && stack.pop() != '{') || (character == ')' && stack.pop() != '(') || (character == ']' && stack.pop() != '[')) return false;

            }
            else stack.push(character);

        } //end of for
        if (!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String args[]) {}
}

```
---

### Implement_a_MinStack
#### TC: O(1)  ,
- Notes
- [Back to Top](#Table-of-contents)
```java
public class MinStack {
    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    //constructor
    public MinStack(int maxSize) {
        //We will use two stacks mainStack to hold original values
        //and minStack to hold minimum values. Top of minStack will always
        //be the minimum value from mainStack
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        minStack = new Stack<>(maxSize);
    }
    //removes and returns value from stack
    public int pop(){
        //1. Pop element from minStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        minStack.pop();
        return mainStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value){
        //1. Push value in mainStack and check value with the top value of minStack
        //2. If value is greater than top, then push top in minStack
        //else push value in minStack
        mainStack.push(value);
        if(!minStack.isEmpty() && minStack.top() < value)
            minStack.push(minStack.top());
        else
            minStack.push(value);
    }
    //returns minimum value in O(1)
    public int min(){
        return minStack.top();
    }
}

```
---
---

## Binary_Tree_Iteration
### Inorder, PreOrder and Post Order Traversal. 
#### TC: O(n), SC: O(n)
- In-Order 
- [Back to Top](#Table-of-contents)
```java
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }
}
```
- Pre-Order
- [Back to Top](#Table-of-contents)
```java
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pollLast();
      output.add(node.val);
      if (node.right != null) {
        stack.add(node.right);
      }
      if (node.left != null) {
        stack.add(node.left);
      }
    }
    return output;
  }
}
```
- Post-Order
- [Back to Top](#Table-of-contents)
```java
class Solution {
  //using one stack - TC-O(2N), SC- O(N)
  public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> ans = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    if (root == null) return ans;

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      ans.addFirst(cur.val);
      if (cur.left != null) {
        stack.push(cur.left);
      }
      if (cur.right != null) {
        stack.push(cur.right);
      }
    }
    return ans;
  }
}
```
- Post-Order (Using 2 Stack)
- [Back to Top](#Table-of-contents)
```java
class Solution {
  //using 2 stack 
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> postOrder = new ArrayList<>();
    Stack<TreeNode> st1 = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();

    if( root == null)
      return postOrder;

    st1.push(root);

    while( !st1.isEmpty() ){
      root = st1.pop();
      st2.push(root);
      if( root.left != null)  st1.push(root.left);
      if( root.right != null) st1.push(root.right);

    }

    while(!st2.isEmpty()) {
      postOrder.add(st2.pop().val);
    }
    return postOrder;
  }
}
```
---

### BFS_Tree_Using_Queue 
#### TC:  , MC:
- Level Order Traversal
- [Back to Top](#Table-of-contents)
```java
class BinaryTree {
 
    Node root;
 
    /* Given a binary tree. Print
     its nodes in level order
     using array for implementing queue  */
    void printLevelOrder()
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
```
---


## Priority Queue aka Heap
---
---
### Sort Array of String by diff of vowels and consonants
#### TC: O(n^2) , MC: O(N)
- Using the Priority a
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
---

