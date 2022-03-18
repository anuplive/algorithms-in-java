
### Table of contents
=================
<!--ts-->
* [Conversions](#Conversions)
* [String](#String)
* [Array and Arrays](#Array_and_Arrays)
* [List , ArrayList, LinkedList](#List_ArrayList_LinkedList)
* [Stack Queue PriorityQueue and Deque](#Stack_Queue_PriorityQueue_and_Deque)
* [HashMap , TreeMap, Hash Set and TreeSet](#HashMap_TreeMap_Hash_Set_and_TreeSet)
* [Enum](#Enum)
<!--te-->

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

## String
- [Back to Top](#Table-of-contents)
```java
[0-9] 48 - 57 , [A-Z] 65 - 90 and  [a-z] 97 - 122 
String s = "a*b*c";
s.length();
s.charAt(i);
s.indexOf('a');
s.indexOf("b*");
s.substring(start); // (start, s.length)
s.substring(start, end); // (start, end)
s.equals("something");
s.compare("something");
s.contains("someString");
s.codePointAt(index)// should be value between 0 - 65,538 valis Ascii character;
Character.isWhiteSpace("something");
Character.isLetterOrDigit('c');
List<String> sList = Arrays.asList(s.trim().split("\\s+"));
Collections.reverse(sList);
return String.join(" ", sList);

```

### String to Array
- [Back to Top](#Table-of-contents)
```java

char[] arr = s.toCharArray();
String[] srt = s.split("\\.");
```

### Array to String
```java

String s = new String (new char[]{'a', 'b'});
String result = String.join("delimiter", List<String>listOfString);

```

### String Builder 

```java
StringBuilder sb = new StringBuilder();
sb.append("something");
sb.insert(int index, "String");
sb.deleteCharAt(int index)
sb.reverse();
sb.toString;
sb.length();

```

- [Back to Top](#Table-of-contents)

## Array and Arrays
- [Back to Top](#Table-of-contents)
```java

int[] arr = new int[2];
Arrays.sort(arr);
Arrays.sort(arr, ((a, b) -> a -b));
Arrays.fill(arr, -1);
List<Integer> list = Arrays.asList(arr)
Integer[] arrInt = list.toArray(new Integer[list.size()]);
int [] arr = new int[]{1,2,3};

```

## HashMap , TreeMap, Hash Set and TreeSet
- [Back to Top](#Table-of-contents)
#### HashMap

```java
HashMap<Character, Integer> map = new HashMap<Character, Integer>();
for (Map.Entry<String, String> set : foodTable.entrySet()) {
System.out.println(set.getKey() + " = " + set.getValue());
}
map.put(key, value); // returns null if no key , else returns previous value before instering;
map.get(key);
map.getOrDefault(key, defaultValue);
map.remove(key);
map.containsKey(key);
map.isEmpty();
map.size();

```


# iterating thorugh the HashMaps 
- [Back to Top](#Table-of-contents)
```java

for (Key key: map.keySet()){}
for (Value value: map.values()){}
for (Map.Entry<Key, Value> entry : map.entrySet()){
    entry.getKey();
    entry.getValue();
}
map.foreach((k,v) -> System.out.println(" %s %d".format(k, v)));

```

# HashSet
- [Back to Top](#Table-of-contents)
```java
HashSet<String> set = new HashSet();
set.add("string");
set.contains("someString");
set.remove("someString");
set.isEmpty();
set.size();

```


# Set join operations
- [Back to Top](#Table-of-contents)
```java
HashSet<String> setA = new HashSet<String>();
HashSet<String> setB = new HashSet<String>();
```


```java
# inner join aka SetA common SetB 
setA.retailAll(setB)
# SetA - SetB
setA.removeAll(setB)
# SetA + SetB
SetA.addAll(SetB)
# check subset
SetA.containsAll(SetB) 
# Set to Arrary
String [] str = set.toArray();

```


### TreeMap
```java

TreeMap<String, Integer> treeMap = new TreeMap<>();             // sorted in lexicographical order
TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder()); // descending order
treeMap.lowerKey(k); // return the greatest key strictly less than the given key, 
treeMap.floorKey(k); // return the greatest key less than or equal to key
treeMap.higherKey(k); // return the greatest key strictly larger than the given key, 
treeMap.ceilingKey(k); // return the greatest key larger than or equal to key
treeMap.firstKey(); // returns the first (lowest) key currently in this 

```

# ####### TreeSet
```java

Set<Integer> treeSet = new TreeSet<>();// sort in ascending order by default
treeSet.lower(Integer e);// return greatest element that is < e, or null if no such element
treeSet.floor(Integer e);// return greatest element that is <= e, or null if no such element
treeSet.ceiling(Integer e);// return smallest element that is >= e, or null if no such element
treeSet.higher(Integer e);// return smallest element that is > e, or null if no such element
treeSet.first(); // return the first element in the treeset (if min set, return minimum element)

```


## List , ArrayList, LinkedList
- [Back to Top](#Table-of-contents)
```java
List<Integer> list = new ArrayList<>(); 
list.add(10);
list.indexOf(10);
list.add(index, 10);
list.get(index);
list.remove(index);
list.set(index, 10);
list.subList(startIndex, endIndex);

```


### Sorting
- [Back to Top](#Table-of-contents)
```java

Collections.sort(list)
Collections.sort(list, Collections.reverseOrder());
Collections.sort(List, new Comparator<Integer>(){
    @Override
    public int compare(Integer this, Integer that){
        return this - that;
    }
} )
list.forEach(x -> System,out,println(x));

```

# LinkedList 

```java
LinkedList<Integer> list = new LinkedList<Integer>();
list.addFirst(element);
list.getFirst();
list.addLast();
list.getLast();

```


## Stack Queue PriorityQueue and Deque
- [Back to Top](#Table-of-contents)
```java
Stack<Integer> stack = new Stack();
stack.pop();
stack.peek();
stack.push(10);
stack.isEmpty();
stack.size();

```



Queue<Integer> queue = new LinkedList<Integer>();
- [Back to Top](#Table-of-contents)
```java
queue.offer(10);
queue.poll();
queue.peek();
queue.isEmpty();
queue.size();

PriorityQueue<Integer> pq = new PriorotyQueue<>((a, b) -> (a-b));
```


- [Back to Top](#Table-of-contents)
```java
Deque<Integer> dq = new LinkedList<Integer>();
dq.addFirst(10);
dq.addLast(10);
dq.peekFirst();
dq.peekLast();
dq.pollFirst();
dq.pollLast();

```


## Enum 

```java

public enum Name {
    HOME, HELLO, HERE;
}

private Name e = Name.HOME;

```







new char[]{'a', 'b'} // initialize a new charArray
int[] test = {1,2,3} // Initialize a new int[] array
