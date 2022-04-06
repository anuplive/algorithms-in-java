# MULTI-Threading
(https://www.javamadesoeasy.com/2015/03/semaphore-used-for-implementing.html)
### Table of contents
=================
<!--ts-->
* [PRODUCER_CONSUMER](#PRODUCER_CONSUMER)
  * [Semaphores](#Semaphores)
  * [Wait_Notify](#Wait_Notify)
    * [Why wait(), notify() Theory](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-why-wait-notify-and-notifyall-must-be-called-from-inside-of-the-synchronized-block-or-method)
    * [Example1](#Example1)
    * [BetterExample_WITH_DEADLOCK](#BetterExample_WITH_DEADLOCK)
  * [Custom_Blocking_Queue](#Custom_Blocking_Queue)
  * [BlockingQueue_JAVA](#BlockingQueue_JAVA)
  * [EVEN_AND_ODD](#EVEN_AND_ODD)
    * [semaphore](#semaphore)
    * [Simple_Threads](#Simple_Threads)
    * [Executor_Service](#Executor_Service)
    * 
  * [MULTI_PRODUCER_CONSUMER](#MULTI_PRODUCER_CONSUMER)
---
* [COUNT_DOWNLATCH](#COUNT_DOWNLATCH)
  * 
---
* [CYCLIC_BARRIER](#CYCLIC_BARRIER)
---
---
* [EXECUTOR_SERVICE](#EXECUTOR_SERVICE)
  *[Thread_Pool](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-what-is-thread-pool-how-can-we-create-thread-pool-in-java) 
  * [execute()](#execute())
    
  * [submit()](#submit())
  * [PRODUCER_CONSUMER](#PRODUCER_CONSUMER)
  * 
---
* **QUESTION BANK**
  * [daemon Thread?](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-what-is-difference-between-user-thread-and-daemon-thread)
  * [Thread Priority](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-what-do-you-understand-about-thread-priority)
  * [What is Deadlock](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-what-is-deadlock-how-to-analyze-and-avoid-deadlock-situation)
  * [How safety of a thread achieved?](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-how-is-the-safety-of-a-thread-achieved)
  * [Create Immutable Class](https://dzone.com/articles/how-to-create-an-immutable-class-in-java)
  * [Thread Dump](https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md#q-what-is-java-thread-dump-how-can-we-get-java-thread-dump-of-a-program)
  * [JVM_Heap_memory](#JVM_Heap_memory)
  * 
---
* **JVM** 
* [JVM_QUESTIONS](https://www.javamadesoeasy.com/2017/03/top-30-jvmjava-virtual-machine.html)
* [JVM_HEAP_STRUCTURE](https://www.javamadesoeasy.com/2016/10/jvm-heap-memory-hotspot-heap-structure.html)
* [FIX_OUTOFMEMORY_HEAPSCAPE](https://www.javamadesoeasy.com/2017/02/exception-in-thread-javalangoutofmemory.html)
* [FIXING MEMORY LEAKS](https://www.javamadesoeasy.com/2016/12/detecting-and-fixing-memory-leak-in-java.html)
* [ANALYZE_GARBAGE_COLLECTOR](https://www.javamadesoeasy.com/2016/12/how-to-monitor-and-analyze-garbage.html)
* [GENERATE HEAPDUMP](https://www.javamadesoeasy.com/2016/11/how-to-use-jhat-to-analyze-heat-dump.html)
---
* [PERFORMANCE_NOTES](#PERFORMANCE_NOTES)
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
#### Example1
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
#### BetterExample_WITH_DEADLOCK
```java
// Message Class 
class Message {
    String message;
    boolean empty = true;

    //Method used by reader
    public synchronized String read() {
      while (empty) {
        try {
                /*
                 Reader thread waits until Writer invokes the notify()
                 method or the notifyAll() method for 'message' object.
                 Reader thread releases ownership of lock and waits
                 until Writer thread notifies Reader thread waiting on
                 this object's lock to wake up either through a call to
                 the notify method or the notifyAll method.
                 */
          wait();
        } catch (InterruptedException e) {
          System.out.println(Thread.currentThread().getName() + "Interrupted.");
        }
      }
        empty = true;//Reader reads the message and marks empty as true.
      /*
         Wakes up all threads that are waiting on 'message' object's monitor(lock).
         This thread(Reader) releases the lock for 'message' object.
         */
      notifyAll();
      return message;//Reader reads the message.
    }

    //Method used by writer
    public synchronized void write(String message) {
      while (!empty) {
        try {
                /*
                 Writer thread waits until Reader invokes the notify()
                 method or the notifyAll() method for 'message' object.
                 Writer thread releases ownership of lock and waits
                 until Reader thread notifies Writer thread waiting on
                 this object's lock to wake up either through a call to
                 the notify method or the notifyAll method.
                 */
          wait();
        } catch (InterruptedException e) {
          System.out.println(Thread.currentThread().getName() + "Interrupted.");
        }
      }
        this.message = message;//Writer writes the message.
        empty = false;//Now make empty as false.
       /*
         Wakes up all threads that are waiting on 'message' object's monitor(lock).
         This thread(Writer) releases the lock for 'message' object.
         */
         notifyAll();
    }
}
// Writer Class
class Writer implements Runnable {
  private Message message;

  public Writer(Message message) {
    this.message = message;
  }

  @Override
  public void run() {
    String messages[] = {
            "Humpty Dumpty sat on a wall",
            "Humpty Dumpty had a great fall",
            "All the king's horses and all the king's men",
            "Couldn't put Humpty together again"
    };

    Random random = new Random();

    for (int i = 0; i < messages.length; i++) {
      message.write(messages[i]);
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException e) {
        System.out.println("Writer Thread Interrupted!!!");
      }
    }
    message.write("Finished!");
  }
}
// Reader.class 
class Reader implements Runnable {

  private Message message;

  public Reader(Message message) {
    this.message = message;
  }

  @Override
  public void run() {
    Random random = new Random();
    for (String latestMessage = message.read(); !"Finished!".equals(latestMessage); latestMessage = message.read()) {
      System.out.println(latestMessage);
      try {
        Thread.sleep(random.nextInt(2000));
      } catch (InterruptedException e) {
        System.out.println("Reader Thread Interrupted!!!");
      }
    }
  }
}

public class Main {
  public static void main(String[] args) {
    //Shared message object between Reader and Writer threads.
    Message message = new Message();

    Thread writerThread = new Thread(new Writer(message));
    Thread readerThread = new Thread(new Reader(message));

    writerThread.start();
    readerThread.start();
  }
}



```



---
----
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

### EVEN_AND_ODD
#### semaphore

- Using Semaphore
- [Back to Top](#Table-of-contents)
```java
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        PrintNumberSeries zeo = new PrintNumberSeries(100);
        Thread t1 = new PrintNumberSeriesThread(zeo,"even");
        Thread t2 = new PrintNumberSeriesThread(zeo,"odd");
        t1.start();
        t2.start();

    }
}

class PrintNumberSeries {
    private int n;
    private Semaphore  oddSem, evenSem;

    public PrintNumberSeries(int n) {
        this.n = n;
        oddSem = new Semaphore(1);
        evenSem = new Semaphore(0);
    }

    public void PrintEven() {
        for (int i = 2; i <= n; i += 2) {
            try {
                evenSem.acquire();
            }
            catch (Exception e) {
            }
            System.out.print(i);
            oddSem.release();
        }
    }
    public void PrintOdd() {
        for (int i = 1; i <= n; i += 2) {
            try {
                oddSem.acquire();
            }
            catch (Exception e) {
            }
            System.out.print(i);
            evenSem.release();
        }
    }
}
class PrintNumberSeriesThread extends Thread {
    PrintNumberSeries zeo;
    String method;
    public PrintNumberSeriesThread(PrintNumberSeries zeo, String method){
        this.zeo = zeo;
        this.method = method;
    }
    public void run() {
        if ("even".equals(method)) {
            try {
                zeo.PrintEven();
            }
            catch (Exception e) {
            }
        }
        else if ("odd".equals(method)) {
            try {
                zeo.PrintOdd();
            }
            catch (Exception e) {
            }
        }
    }
}


```
---
#### Simple_Threads
- Using Simple Threads
- [Back to Top](#Table-of-contents)
```java
public class OddEvenWithThread {
  public static void main(String a[]) {
    Thread t1 = new Thread(new OddEvenRunnable(0), "Even Thread");
    Thread t2 = new Thread(new OddEvenRunnable(1), "Odd Thread");

    t1.start();
    t2.start();
  }
}
class OddEvenRunnable implements Runnable {
  Integer evenflag;
  static Integer number = 1;
  static Object lock = new Object();

  OddEvenRunnable(Integer evenFlag) {
    this.evenflag = evenFlag;
  }

  @Override
  public void run() {
    while (number < 10) {
      synchronized (lock) {
        try {
          while (number % 2 != evenflag) {
            lock.wait();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " " + number);
        number++;
        lock.notifyAll();
      }
    }
  }
}

```
---
#### Simple_Threads_version2
- Using Simple Threads version2
- [Back to Top](#Table-of-contents)
```java
// Java program for the above approach
public class GFG {
  // Starting counter
  int counter = 1;
  static int N;
  // Function to print odd numbers
  public void printOddNumber()
  {
    synchronized (this)
    {
      // Print number till the N
      while (counter < N) {

        // If count is even then print
        while (counter % 2 == 0) {

          // Exception handle
          try {
            wait();
          }
          catch (
                  InterruptedException e) {
            e.printStackTrace();
          }
        }

        // Print the number
        System.out.print(counter + " ");

        // Increment counter
        counter++;

        // Notify to second thread
        notify();
      }
    }
  }

  // Function to print even numbers
  public void printEvenNumber()
  {
    synchronized (this)
    {
      // Print number till the N
      while (counter < N) {

        // If count is odd then print
        while (counter % 2 == 1) {

          // Exception handle
          try {
            wait();
          }
          catch (
                  InterruptedException e) {
            e.printStackTrace();
          }
        }

        // Print the number
        System.out.print(
                counter + " ");

        // Increment counter
        counter++;

        // Notify to 2nd thread
        notify();
      }
    }
  }

  // Driver Code
  public static void main(String[] args)
  {
    // Given Number N
    N = 10;

    // Create an object of class
    GFG mt = new GFG();

    // Create thread t1
    Thread t1 = new Thread(new Runnable() {
      public void run()
      {
        mt.printEvenNumber();
      }
    });

    // Create thread t2
    Thread t2 = new Thread(new Runnable() {
      public void run()
      {
        mt.printOddNumber();
      }
    });

    // Start both threads
    t1.start();
    t2.start();
  }
}

```
---

#### Executor_Service
- Using Executor_Service
- [Back to Top](#Table-of-contents)
```java
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

  public static void main(String[] args){
    final int max = 100;
    final AtomicInteger i = new AtomicInteger(0);
    Executor dd = Executors.newFixedThreadPool(2);

    final Object lock = new Object();

    dd.execute(new Runnable() {
      @Override
      public void run() {
        while (i.get() < max) {
          if (i.get() % 2 == 0) {
            System.out.print(" " + i.getAndAdd(1));

            synchronized(lock){
              lock.notify();
            }
          }else{
            synchronized(lock){
              try {
                lock.wait();
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }
          }
        }
      }
    });
    dd.execute(new Runnable() {
      @Override
      public void run() {
        while (i.get() < max) {
          if (i.get() % 2 != 0) {
            System.out.print(" " + i.getAndAdd(1));

            synchronized(lock){
              lock.notify();
            }
          }else{
            synchronized(lock){
              try {
                lock.wait();
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }
          }
        }
      }
    });
    do {
      try {
        Thread.currentThread().sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (i.get() != max);
    System.out.println("\nDone");
  }
}

```
---


---
---
## COUNTDOWN_LATCH
```java

import java.util.concurrent.CountDownLatch;
/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class CountDownLatchTest {
  public static void main(String[] args) {
    CountDownLatch countDownLatch=new CountDownLatch(3);
    System.out.println("CountDownLatch has been created with count=3");

    new Thread(new MyRunnable(countDownLatch),"Thread-1").start();

    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("count has reached zero, "+
            Thread.currentThread().getName()+" thread has ended");


  }

}
 
class MyRunnable implements Runnable{
    CountDownLatch countDownLatch;
    MyRunnable(CountDownLatch countDownLatch){
           this.countDownLatch=countDownLatch;
    }
    
    
    public void run(){
           
           for(int i=2;i>=0;i--){
                  
                  countDownLatch.countDown();           
                  System.out.println(Thread.currentThread().getName()+
                               " has reduced latch count to : "+ i);
                  
                  try {
                        Thread.sleep(1000);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
           }
                  
    }
    
}
/**OUTPUT
 
CountDownLatch has been created with count=3
Initially, CountDownLatch is created with count=3
main thread called countDownLatch.await() and it is waiting for count to become 0.
Thread-1 called countDownLatch.countDown()  method. [Now, count=2]
Thread-1 has reduced latch count to : 2

Thread-1 called countDownLatch.countDown()  method. [Now, count=1]
Thread-1 has reduced latch count to : 1

Thread-1 called countDownLatch.countDown()  method. [Now, count=0]
Thread-1 has reduced latch count to : 0

count has reached zero, main thread has ended
As, count has reached zero, main thread has ended.
 
*/
```

---
## CYCLIC_BARRIER
### Example 
#### TC:  , MC:
- Some comment
- [Back to Top](#Table-of-contents)
```java
package CyclicBarrier;
 
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
public class CyclicBarrierTest {
    public static void main(String[] args) {
           /*
            * Create CountDownLatch with 3 parties, when all 3 parties
            * will reach common barrier point CyclicBarrrierEvent will be
            * triggered i.e. run() method of CyclicBarrrierEvent will be called
            */
           CyclicBarrier cyclicBarrier=new CyclicBarrier(3 ,new CyclicBarrrierEvent());
           System.out.println("CountDownLatch has been created with parties=3,"
                        + " when all 3 parties will reach common barrier point "
                        + "CyclicBarrrierEvent will be triggered");
 
           MyRunnable myRunnable1=new MyRunnable(cyclicBarrier);
           
           //Create and start 3 threads
           new Thread(myRunnable1,"Thread-1").start();
           new Thread(myRunnable1,"Thread-2").start();
           new Thread(myRunnable1,"Thread-3").start();
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    //Create and start 3 more threads
      new Thread(myRunnable1,"Thread-4").start();
      new Thread(myRunnable1,"Thread-5").start();
      new Thread(myRunnable1,"Thread-6").start();
           
    }
}
class CyclicBarrrierEvent implements Runnable{

  public void run() {
    System.out.println("As all threads have reached common barrier point "
            + ", CyclicBarrrierEvent has been triggered");
  }

}
class MyRunnable implements Runnable{
 
    CyclicBarrier cyclicBarrier;
    
    MyRunnable(CyclicBarrier cyclicBarrier){
           this.cyclicBarrier=cyclicBarrier;
    }
    
    @Override
    public void run() {
           
           System.out.println(Thread.currentThread().getName() +
                        " is waiting for all other threads to reach common barrier point");
 
           try {
                  Thread.sleep(1000);
                  /*
                   * when all 3 parties will call await() method (i.e. common barrier point)
                   * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
                   */
                  cyclicBarrier.await();
           } catch (InterruptedException e) {
                  e.printStackTrace();
           } catch (BrokenBarrierException e) {
                  e.printStackTrace();
           }          
           
           System.out.println("As all threads have reached common barrier point "
                        + Thread.currentThread().getName() +
                        " has been released");
    }
    
}

```
---

---
## PERFORMANCE_NOTES
- [Back to Top](#Table-of-contents)
```java
/**
 * LINUX
 nohup ./bash.sh -c 'cal && ls' > output.txt // runs even after the session is exited 

##########
 // ClassNotFoundException v/s NoClassDefFoundError
 // java.lang.ClassNotFoundException
 Class.forName("oracle.jdbc.driver.OracleDriver");
 }catch (ClassNotFoundException e)

 // java.lang.NoClassDefFoundError
 class A{}
 public class 
 {   public static void main(String[] args)
 {   A a = new A();}
 }

 Then Remove the class A.class and run java B 
 ##########
 JVM arguments (https://www.jrebel.com/sites/rebel/files/pdfs/cheat-sheet-rebel-jvm-options.pdf)

 1. Standard Options (-D but not only).
 You use -D to specify System properties but most of them don't have any prefix :-verbose, -showversion, and so for...
 -Dblog=JRebelBlog
 System.setProperty("blog", "JRebel"); System.getProperty("blog");
 -verbose option during the runtime;


 2. Non-Standard Options (prefixed with -X)
 To override the default bootstrap class : 
 -Xbootclasspath:path 
 -Xbootclasspath/a:path and -Xbootclasspath/p:path

 Setting the Initial and Max size of Heap(only for old generation) -Xmssize, -Xmxsize //  -Xms1g -Xmx8g 


 3. Advanced Runtime Options (prefixed with -XX)
 Runtime Behaviour
 These options control the runtime behavior of the Java HotSpot VM.

 4. Perfromance
 -XX:ThreadStackSize=256k

 5. Debugging.
 -XX:ErrorFile=file.log
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:+TraceClassLoading

 6. Garbage Collection Options 
 These options control how garbage collection (GC) is performed by the Java HotSpot VM.
 -XX:+UseConcMarkSweepGC
 -XX:+UseParallelGC
 -XX:+UseSerialGC
 -XX:+UseG1GC
 -XX:+UseZGC


 OutOfMemoryError is thrown in java?
 It is the perfect time to get your heap details (i.e. heap dump) and to spot what exactly went wrong at the time when OutOfMemoryError is thrown in java, we can use it for analyzing the garbage collection in java.

 Heap dump will be generated when OutOfMemoryError is thrown by specifying -XX:+HeapDumpOnOutOfMemoryError VM option.
 */

```
## JVM_Heap_memory
- [Back to Top](#Table-of-contents)
```java


```

