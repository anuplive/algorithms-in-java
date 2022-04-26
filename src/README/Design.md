# Topic

### Table of contents
=================
<!--ts-->
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
