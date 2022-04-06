# Topic

### Table of contents
=================
<!--ts-->
* [Caching](#Caching)
  * [LRU_Cache](#LRU_Cache) and [LFU_Cache](#LFU_Cache) 
---
* [SINGLETON](#SINGLETON)
  * [Eager_Initialization](#Eager_Initialization)
  * [StaticBlockSingleton](#StaticBlockSingleton)
  * [Lazy_Initialization](#Lazy_Initialization)
  * [Thread_Safe_Singleton](#Thread_Safe_Singleton)
---
* [Adapter_Design_Pattern](#Adapter_Design_Pattern)
  * [Media_Player](#Media_Player)
---
* [Factory_Design_Pattern](#Factory_Design_Pattern) 
  * [CUSTOMER_BILL_PLAN](#CUSTOMER_BILL_PLAN)
---
* [Strategy_Design_Pattern](#Strategy_Design_Pattern)
  * [PaymentStrategy](https://github.com/learning-zone/java-interview-questions/blob/master/java-design-pattern-questions.md#q-explain-strategy-design-pattern-in-java)
<!--te-->
   ---
## Caching
- Lazy v/s Eager  
---
### LRU_Cache
#### TC:  , MC:
- Detailed Solution 1
- Capacity evaluated using size()
- [Back to Top](#Table-of-contents)
```java
class Node {
    int key, value;
    Node prev, next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    Node() {
        this(0,0);
    }
}

class LRUCache {
    Node head = new Node();
    Node tail = new Node();

    int capacity;
    Map<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(nodeMap.containsKey(key)) {
            removeNode(nodeMap.get(key));
            Node newNode = new Node(key, nodeMap.get(key).value);
            moveNodeToHead(newNode);
            nodeMap.put(key, newNode);
            return nodeMap.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(!nodeMap.containsKey(key)) {
            if(nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        } else {
            removeNode(nodeMap.get(key));
        }
        Node newNode = new Node(key, value);
        moveNodeToHead(newNode);
        nodeMap.put(key, newNode);
    }

    public void moveNodeToHead(Node newNode) {
        Node temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    public void removeNode(Node temp) {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
}
```
---
- Simple Solution LinkedHashMap 
- [Back to Top](#Table-of-contents)
```java
class LRUCache {
    private int capacity;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            int value = (int)map.get(key);
            map.remove(key);
            map.put(key, value);

            return value;
        }

        return -1;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key, value);

        } else {
            map.put(key, value);
            int size = map.size();

            if(size > capacity){
                int oldest_key = map.keySet().iterator().next();
                map.remove(oldest_key);
            }
        }
    }
}


```
---
- Detailed Solution 
- Capacity evaluated without calling size
- [Back to Top](#Table-of-contents)
```java
class LRUCache {
    Map<Integer, Node> cache;
    LRUCache.Node Head;
    LRUCache.Node Last;

    static class Node {
        Node forward;
        Node backward;
        Integer key;
        Integer value;
    }

    public LRUCache(int capacity) {
        Head = new LRUCache.Node();
        Last = new LRUCache.Node();
        Head.forward = Last;
        Last.backward = Head;

        for (int i = 0; i < capacity; i++) {
            insertNode(new LRUCache.Node(), false);
        }

        cache = new HashMap<Integer, Node>() ;

    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LRUCache.Node node = cache.get(key);
            repositionNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LRUCache.Node node = cache.get(key);
            node.value = value;
             
        } else {
            LRUCache.Node node = new LRUCache.Node();
            node.key = key;
            node.value = value;
            cache.put(key, node);
            LRUCache.Node deleteCache = insertNode(node, true);
            if (deleteCache != null && deleteCache.key != null) {
                cache.remove(deleteCache.key);
            }
        }
    }

    public LRUCache.Node insertNode(LRUCache.Node node, boolean withPoll) {
        LRUCache.Node prevNode = Last.backward;
        node.forward = Last;
        node.backward = prevNode;
        prevNode.forward = node;
        Last.backward = node;
        if (withPoll) {
            return poll();
        }
        return null;
    }

    public LRUCache.Node poll() {
        LRUCache.Node node = Head.forward;
        if (node != Last) {
            Head.forward = node.forward;
            node.forward.backward = Head;
            return node;
        }
        return null;
    }

    public void repositionNode(LRUCache.Node node) {
        LRUCache.Node nextNode = node.forward;
        LRUCache.Node prevNode = node.backward;
        prevNode.forward = nextNode;
        nextNode.backward = prevNode;
        insertNode(node, false);
    }

    
}

```
---
### LFU_Cache
#### TC:  , MC:
- Uses a Node and Node List
- Later calls the Node and Node List in the LFU Cache
- Capacity evaluated using size()
- [Back to Top](#Table-of-contents)
```java
class Node{
    int frequency = 1, key, value;
    Node pre, next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class NodeList{
    Node head;
    
    Node tail;
    int curSize = 0;
    public NodeList(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }
    
    public void deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        curSize--;
    }
    
    public void addNode(Node node){
        Node temp = head.next;
        head.next = node;
        node.next = temp;
        node.pre = head;
        temp.pre = node;
        curSize++;
    }
}

class LFUCache {
    int minFreq = 1;
    Map<Integer, Node> lru = new HashMap<>();
    Map<Integer, NodeList> lfu = new HashMap<>();
    int capacity;
    int curFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;    
    }
    
    public int get(int key) {
        if(lru.containsKey(key)) {
            updateNode(lru.get(key));
            return lru.get(key).value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
         if (capacity == 0) {
            return;
        }
        if(lru.containsKey(key)) {
            lru.get(key).value = value;
            updateNode(lru.get(key));
        }
        else { 
            if(lru.size() == capacity) {
                NodeList curList = lfu.get(minFreq);
                lru.remove(curList.tail.pre.key);
                curList.deleteNode(curList.tail.pre);
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            NodeList curList = lfu.getOrDefault(1, new NodeList());
            curList.addNode(newNode);
            lru.put(key, newNode);
            lfu.put(minFreq, curList);
        }
    }
    
     public void updateNode(Node node){
        curFreq = node.frequency;
        NodeList nd = lfu.get(curFreq);
        nd.deleteNode(node);
         lru.remove(node.key);
         
        if(curFreq == minFreq && nd.curSize == 0) minFreq++;
        
        NodeList newList = lfu.getOrDefault(curFreq+1, new NodeList());
        node.frequency++;
        newList.addNode(node);
        lru.put(node.key, node);
        lfu.put(node.frequency, newList);
    }
}
```
---

---

---
---
## SINGLETON
### Eager_Initialization
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
/**
 * 1. Eager initialization:
 In eager initialization, the instance of Singleton Class is created at the time of class loading.

 Example:
 */
public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    // private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
//
```
---

---
### StaticBlockSingleton
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
/**
 * Static block initialization implementation is similar to eager initialization, except that instance of class is created in the static block that provides option for exception handling.


 */
public class StaticBlockSingleton  {

  private static StaticBlockSingleton  instance;

  private StaticBlockSingleton (){}

  // static block initialization for exception handling
  static{
    try{
      instance = new StaticBlockSingleton ();
    }catch(Exception e){
      throw new RuntimeException("Exception occured in creating Singleton instance");
    }
  }

  public static StaticBlockSingleton getInstance(){
    return instance;
  }
}

```
---

### Lazy_Initialization
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
/**
 * Lazy initialization method to implement Singleton pattern creates the instance in the global access method.
 */
public class LazyInitializedSingleton  {

  private static LazyInitializedSingleton  instance;

  private LazyInitializedSingleton(){}

  public static LazyInitializedSingleton  getInstance(){
    if(instance == null){
      instance = new LazyInitializedSingleton ();
    }
    return instance;
  }
}

```
---

### Thread_Safe_Singleton
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    
    private ThreadSafeSingleton(){}
    
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

```
---

---
## Adapter_Design_Pattern
### Media_Player
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
/**
 * Adapter design pattern is one of the structural design pattern and its used so 
 * that two unrelated interfaces can work together. The object that joins these 
 * unrelated interface is called an Adapter.

 Example:

 we have two incompatible interfaces: MediaPlayer and MediaPackage. MP3 class is 
 an implementation of the MediaPlayer interface and we have VLC and MP4 as 
 implementations of the MediaPackage interface. We want to use MediaPackage 
 implementations as MediaPlayer instances. So, we need to create an adapter to 
 help to work with two incompatible classes.
 */
// MediaPlayer.java
public interface MediaPlayer {
  void play(String filename);
}

//MediaPackage.java
public interface MediaPackage {
  void playFile(String filename);
}

//MP3.java
public class MP3 implements MediaPlayer {
  @Override
  public void play(String filename) {
    System.out.println("Playing MP3 File " + filename);
  }
}

//MP4.java
public class MP4 implements MediaPackage {
  @Override
  public void playFile(String filename) {
    System.out.println("Playing MP4 File " + filename);
  }
}

//VLC.java
public class VLC implements MediaPackage {
  @Override
  public void playFile(String filename) {
    System.out.println("Playing VLC File " + filename);
  }
}
// FormatAdapter.java
public class FormatAdapter implements MediaPlayer {
  private MediaPackage media;
  public FormatAdapter(MediaPackage m) {
    media = m;
  }
  @Override
  public void play(String filename) {
    System.out.print("Using Adapter --> ");
    media.playFile(filename);
  }
}
//Main.java
public class Main {
  public static void main(String[] args) {
    MediaPlayer player = new MP3();
    player.play("file.mp3");
    player = new FormatAdapter(new MP4());
    player.play("file.mp4");
    player = new FormatAdapter(new VLC());
    player.play("file.avi");
  }
}
```
---
## Factory_Design_Pattern

### CUSTOMER_BILL_PLAN 
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
/**
 *A Factory Pattern or Factory Method Pattern says that just define an interface 
 * or abstract class for creating an object but let the subclasses decide which 
 * class to instantiate. In other words, subclasses are responsible to create the 
 * instance of the class.
 */
// Plan.java
import java.io.*;
abstract class Plan {
  protected double rate;
  abstract void getRate();

  public void calculateBill(int units){
    System.out.println(units*rate);
  }
}  
// DomesticPlan.java
class  DomesticPlan extends Plan{
  @override
  public void getRate(){
    rate=3.50;
  }
}
//CommercialPlan.java
class  CommercialPlan extends Plan{
  @override
  public void getRate(){
    rate=7.50;
  }
}
//InstitutionalPlan.java
class  InstitutionalPlan extends Plan{
  @override
  public void getRate(){
    rate=5.50;
  }
}
//GetPlanFactory.java
class GetPlanFactory {

  // use getPlan method to get object of type Plan   
  public Plan getPlan(String planType){
    if(planType == null){
      return null;
    }
    if(planType.equalsIgnoreCase("DOMESTICPLAN")) {
      return new DomesticPlan();
    }
    else if(planType.equalsIgnoreCase("COMMERCIALPLAN")){
      return new CommercialPlan();
    }
    else if(planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
      return new InstitutionalPlan();
    }
    return null;
  }
}
//GenerateBill.java
//import java.io.*;
class GenerateBill {

  public static void main(String args[])throws IOException {
    GetPlanFactory planFactory = new GetPlanFactory();

    System.out.print("Enter the name of plan for which the bill will be generated: ");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    String planName=br.readLine();
    System.out.print("Enter the number of units for bill will be calculated: ");
    int units=Integer.parseInt(br.readLine());

    Plan p = planFactory.getPlan(planName);
    // call getRate() method and calculateBill()method of DomesticPaln.  

    System.out.print("Bill amount for "+planName+" of  "+units+" units is: ");
    p.getRate();
    p.calculateBill(units);
  }
}

```
---
