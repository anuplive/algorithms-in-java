# MULTI-Threading
(https://www.javamadesoeasy.com/2015/03/semaphore-used-for-implementing.html)
### Table of contents
=================
<!--ts-->
* [PRODUCER_CONSUMER](#PRODUCER_CONSUMER)
  * [Semaphores](#Semaphores)
  * [Wait_Notify](#Wait_Notify)
  * [Custom_Blocking_Queue](#Custom_Blocking_Queue)
  * [BlockingQueue_JAVA](#BlockingQueue_JAVA)
  * [EVEN_AND_ODD](#EVEN_AND_ODD)
  * [MULTI_PRODUCER_CONSUMER](#MULTI_PRODUCER_CONSUMER)
  * 
---
* [EXECUTOR_SERVICE](#EXECUTOR_SERVICE)
  * [execute()](#execute())
  * [submit()](#submit())
  * [PRODUCER_CONSUMER](#PRODUCER_CONSUMER)
  * 
---  

* [GARBAGE_COLLECTION](#GARBAGE_COLLECTION)
<!--te-->


---
## PRODUCER_CONSUMER
### Semaphores
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
import java.util.concurrent.Semaphore;

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */ 
public class ConsumerProducer{
    public static void main(String[] args) {
 
           Semaphore semaphoreProducer=new Semaphore(1);
           Semaphore semaphoreConsumer=new Semaphore(0);
           System.out.println("semaphoreProducer permit=1 | semaphoreConsumer permit=0");
           
       Producer producer=new Producer(semaphoreProducer,semaphoreConsumer);
       Consumer consumer=new Consumer(semaphoreConsumer,semaphoreProducer);
      
        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
 
        producerThread.start();
        consumerThread.start();
 
    }
}
/**
 * Producer Class.
 */
class Producer implements Runnable{
    Semaphore semaphoreProducer;
    Semaphore semaphoreConsumer;
    
    
    public Producer(Semaphore semaphoreProducer,Semaphore semaphoreConsumer) {
           this.semaphoreProducer=semaphoreProducer;
           this.semaphoreConsumer=semaphoreConsumer;
    }
 
    public void run() {
           for(int i=1;i<=5;i++){
                  try {
                      semaphoreProducer.acquire();
                      System.out.println("Produced : "+i);
                      semaphoreConsumer.release();
                        
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
           }          
    }
}
 
/**
 * Consumer Class.
 */
class Consumer implements Runnable{
    Semaphore semaphoreConsumer;
    Semaphore semaphoreProducer;
    
    public Consumer(Semaphore semaphoreConsumer,Semaphore semaphoreProducer) {
           this.semaphoreConsumer=semaphoreConsumer;
           this.semaphoreProducer=semaphoreProducer;
    }
 
    public void run() {
           
           for(int i=1;i<=5;i++){
                  try {
                      semaphoreConsumer.acquire();
                      System.out.println("Consumed : "+i);
                      semaphoreProducer.release();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
           }
    }
    
}
/*OUTPUT
 
semaphoreProducer permit=1 | semaphoreConsumer permit=0
Produced : 1
Consumed : 1
Produced : 2
Consumed : 2
Produced : 3
Consumed : 3
Produced : 4
Consumed : 4
Produced : 5
Consumed : 5
 
*/
```
---

---
### Custom_Blocking_Queue 
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
import java.util.LinkedList;
import java.util.List;
 
 
 
 
/**
 * Implementing custom BlockingQueue interface .
 * This BlockingQueue implementation follows FIFO (first-in-first-out).
 * New elements are inserted at the tail of the queue,
 * and removal elements is done at the head of the queue.
 *
 */
interface BlockingQueueCustom<E> {
      /**
       * Inserts the specified element into this queue
       * only if space is available else 
       * waits for space to become available.
       */
      void put(E item)  throws InterruptedException ;
      /**
       * Retrieves and removes the head of this queue
       * only if elements are available else 
       * waits for element to become available.
       */
      E take()  throws InterruptedException;
}
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
/**
 * Implementing custom LinkedBlockingQueue class.
 * This BlockingQueue implementation follows FIFO (first-in-first-out).
 * New elements are inserted at the tail of the queue,
 * and removal elements is done at the head of the queue.
 *
 * @author AnkitMittal
 * Copyright (c), AnkitMittal .
 * All Contents are copyrighted and must not be reproduced in any form.
 */
class LinkedBlockingQueueCustom<E> implements BlockingQueueCustom<E>{
 
      private List<E> queue;
      private int  maxSize ; //maximum number of elements queue can hold at a time.
 
      public LinkedBlockingQueueCustom(int maxSize){
     this.maxSize = maxSize;
     queue = new LinkedList<E>();
      }
 
 
      /**
       * Inserts the specified element into this queue
       * only if space is available else 
       * waits for space to become available.
       */
      public synchronized void put(E item)  throws InterruptedException  {
            
               //check space is available or not.
               if (queue.size() == maxSize) {
             this.wait();
               }
               
               //space is available, insert.
         queue.add(item);
         this.notify();
      }
 
 
      /**
       * Retrieves and removes the head of this queue
       * only if elements are available else 
       * waits for element to become available.
       */
      public synchronized E take()  throws InterruptedException{
 
             //waits element is available or not.
        if (queue.size() == 0) {
            this.wait();
        }
 
        //element is available, remove.
        this.notify();
         return queue.remove(0);
      }  
}
 
 
/**
 * Producer Class in java
 */
class Producer implements Runnable {
 
    private final BlockingQueueCustom<Integer> sharedQueue;
 
    public Producer(BlockingQueueCustom<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        for(int i=1; i<=10; i++){
         try {
             System.out.println("Produced : " + i);
             //put/produce into sharedQueue.
             sharedQueue.put(i);          
         } catch (InterruptedException ex) {
             
         }
        }
    }
 
}
 
/**
 * Consumer Class in Java
 */
class Consumer implements Runnable{
 
    private BlockingQueueCustom<Integer> sharedQueue;
 
    public Consumer (BlockingQueueCustom<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        while(true){
         try {
           //take/consume from sharedQueue.
             System.out.println("CONSUMED : "+ sharedQueue.take());  
         } catch (InterruptedException ex) {
             
         }
        }
    }
 
 
}
 
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
/**
 * Main class in java
 */
public class ProducerConsumerBlockingQueueCustom {
 
    public static void main(String args[]){
     
     BlockingQueueCustom<Integer> sharedQueue = new LinkedBlockingQueueCustom<Integer>(10); //Creating shared object
    
     Producer producer=new Producer(sharedQueue);
     Consumer consumer=new Consumer(sharedQueue);
    
     Thread producerThread = new Thread(producer, "ProducerThread");
     Thread consumerThread = new Thread(consumer, "ConsumerThread");
     producerThread.start();
     consumerThread.start();
 
    }
 
}

```
---

---
### Wait_Notify
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
import java.util.LinkedList;
import java.util.List;
 
/**
 * Producer Class.
 */
class Producer implements Runnable {
 
    private List<Integer> sharedQueue;
    private int maxSize=2; //maximum number of products which sharedQueue can hold at a time.
 
    public Producer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {  //produce 10 products.
         try {
             produce(i);
         } catch (InterruptedException e) {  e.printStackTrace();   }
        }
}
 
    private void produce(int i) throws InterruptedException {
    
       synchronized (sharedQueue) {
           //if sharedQuey is full wait until consumer consumes.
           while (sharedQueue.size() == maxSize) {
             System.out.println("Queue is full, producerThread is waiting for "
                     + "consumerThread to consume, sharedQueue's size= "+maxSize);
             sharedQueue.wait();
         }
        }
       
       /* 2 Synchronized blocks have been used means before
        * producer produces by entering below synchronized
        * block consumer can consume.  
        */
      
       //as soon as producer produces (by adding in sharedQueue) it notifies consumerThread.
        synchronized (sharedQueue) {  
           System.out.println("Produced : " + i);
           sharedQueue.add(i);
         Thread.sleep((long)(Math.random() * 1000));
         sharedQueue.notify();
        }
    }
}
 
/**
 * Consumer Class.
 */
class Consumer implements Runnable {
    private List<Integer> sharedQueue;
    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
   
    @Override
    public void run() {
        while (true) {
         try {
             consume();
             Thread.sleep(100);
         } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }
 
    private void consume() throws InterruptedException {
      
       synchronized (sharedQueue) {
           //if sharedQuey is empty wait until producer produces.
           while (sharedQueue.size() == 0) {
                  System.out.println("Queue is empty, consumerThread is waiting for "
                               + "producerThread to produce, sharedQueue's size= 0");
             sharedQueue.wait();
         }
       }
       
 
       /* 2 Synchronized blocks have been used means before
        * consumer start consuming by entering below synchronized
        * block producer can produce.  
        */
      
        /*If sharedQueue not empty consumer will consume
      * (by removing from sharedQueue) and notify the producerThread.
      */
        synchronized (sharedQueue) {
           Thread.sleep((long)(Math.random() * 2000));
         System.out.println("CONSUMED : "+ sharedQueue.remove(0));
         sharedQueue.notify();
        }
    }
   
}
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class ProducerConsumerWaitNotify {
 
    public static void main(String args[]) {
       List<Integer> sharedQueue = new LinkedList<Integer>(); //Creating shared object
      
       Producer producer=new Producer(sharedQueue);
       Consumer consumer=new Consumer(sharedQueue);
      
        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();
    }
}

```
---

---
### BlockingQueue_JAVA
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
 
/**
 * Producer Class in java.
 */
class Producer implements Runnable {
 
    private final BlockingQueue<Integer> sharedQueue;
 
    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        for(int i=1; i<=10; i++){
         try {
             System.out.println("Produced : " + i);
             //put/produce into sharedQueue.
             sharedQueue.put(i);          
         } catch (InterruptedException ex) {
             
         }
        }
    }
 
}
 
/**
 * Consumer Class in java.
 */
class Consumer implements Runnable{
 
    private BlockingQueue<Integer> sharedQueue;
 
    public Consumer (BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
 
    @Override
    public void run() {
        while(true){
         try {
           //take/consume from sharedQueue.
             System.out.println("CONSUMED : "+ sharedQueue.take());  
         } catch (InterruptedException ex) {
             
         }
        }
    }
 
 
}
 
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class ProducerConsumerBlockingQueue {
 
    public static void main(String args[]){
     
     //Creating shared object  
     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
    
     Producer producer=new Producer(sharedQueue);
     Consumer consumer=new Consumer(sharedQueue);
    
     Thread producerThread = new Thread(producer, "ProducerThread");
     Thread consumerThread = new Thread(consumer, "ConsumerThread");
     producerThread.start();
     consumerThread.start();
 
    }
 
}
```
---
