# Topic

### Table of contents
=================
<!--ts-->
* [Caching](#Caching)
  * [LRU_Cache](#LRU_Cache) and [LFU_Cache](#LFU_Cache) 
* 
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
