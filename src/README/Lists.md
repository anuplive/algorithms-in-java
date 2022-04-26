# Topic
### Table of contents
=================
<!--ts-->
| Name           |                                           |                                           |   |   |   |
|----------------|-------------------------------------------|-------------------------------------------|---|---|---|
| Implementation | [Doubly Linked List](#Doubly-Linked-List) | [Singly Linked List](#Singly Linked List) |   |   |   |
|                |                                           |                                           |   |   |   |
<!--te-->

### Doubly Linked List
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class MyLinkedList {
    
    Node dummyHead;
    Node dummyTail;
    int size;

    public MyLinkedList() {
        dummyHead = new Node();
        dummyTail = new Node();
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        size = 0;
    }

    class Node {
        int val;
        Node prev;
        Node next;

        Node() {}
        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node getNode(int index) {
        if (index >= size) return null;
        if (index == 0) return dummyHead.next;
        if (index == size - 1) return dummyTail.prev;
        Node temp = dummyHead.next;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp;
    }
    
    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val, dummyHead, dummyHead.next);
        dummyHead.next = node;
        node.next.prev = node;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val, dummyTail.prev, dummyTail);
        node.prev.next = node;
        dummyTail.prev = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else if (index < size && index > 0) {
            Node node = new Node(val, getNode(index - 1), getNode(index));
            getNode(index - 1).next = node;
            getNode(index).prev = node;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index < size) {
            if (index == 0) {
                dummyHead.next = dummyHead.next.next;
                dummyHead.next.prev = dummyHead;
            } else if (index == size - 1) {
                dummyTail.prev = dummyTail.prev.prev;
                dummyTail.prev.next = dummyTail;
            } else {
                Node prevNode = getNode(index - 1);
                prevNode.next = prevNode.next.next;
                if (prevNode.next != null) {
                    prevNode.next.prev = prevNode;
                }
            }
            size--;
        } 
    }
    
    
    
}

```
---
### Singly Linked List
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
class MyLinkedList {
	Node head;
	int length;
    // Definition of the node
    public class Node{
        int val;
        Node next;
        
        Node(int val){
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }
    
    public int get(int index) {
        if(index >= length)
        	return -1;
        int counter = 0;
        Node temp = head;
        while(counter < index) {
        	counter++;
        	temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newnew = new Node(val);
        newnew.next = head;
        head = newnew;
        length++;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
        	addAtHead(val);
        }else {
        	Node temp = head;
        	while(temp.next != null)
        		temp = temp.next;
        	Node newnew = new Node(val);
        	temp.next = newnew;
        	length++;
        }
    }
    
    public void addAtIndex(int index, int val) {
    	if(index > length)
    		return;
        if(index == 0)
        	addAtHead(val);
        else {
        	int counter = 1;
        	Node temp = head;
        	while(counter < index) {
        		temp = temp.next;
        		counter++;
        	}
        	Node newnew = new Node(val);
        	Node next = temp.next;
        	temp.next = newnew;
        	newnew.next = next;
        	length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= length)
        	return;
        if(index == 0) {
        	head = head.next;
        	length--;
        }else {
        	int counter = 1;
        	Node temp = head;
        	while(counter < index) {
        		counter++;
        		temp = temp.next;
        	}
        	temp.next = temp.next.next;
        	length--;
        }
    }
}

```