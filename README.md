### EXECUTOR Example explanation:

 #### Executer 
* each java thread correspond to one OS thread.
* CPU intensive" hashing or cryptographic/video alog..
* IO bound DB/network/File
* if app is cup bound ,then number of thread should be equal to number of 
cores..
* 4 type of threadpool
   * Fixed threadpool, (in blocking Q and thread pick task form it)
   * CachedThread pool , Synchronous  Q ,kill thread if idle, can create any  
   number of thread.
   * ScheduledThreadPool: kind of task that need to eb schduele(scurity check
   .log check evey 10 sec)
	 * service.scheduleAtFixedRAte and service.secheduelATFixedDelay
         * service.schedule(new TAsk(),10)
   * SingleThreadExecutor: same as fixedTP ,if thread is killed, it will 
   recreate a new thread and execute
		 	*  when we want task 1 run before task 2 i.e sequential
 Executor service Argument adn API:
 

#### Executor Service arguments:

 1. Core pool size.
 2. max pool size.
 3. Keep alive time(KAT): time after which the thread pool will kill the thread if idle.

* FixedThread pool: core-size = MAX  and KAT os 0 sec ,LinkedClockingQueue
* CachedThread pool: 0 ,Integer.MAX, 60 sec ,SynchronousQueue
* ScheduledThreadPool: arg,Integer.MAX,60 ,DelayBlockQueue
* SingleThreadPool: 1,1,0sec LinkedBlockingQueue
* CustomeThread pool: ArrayBlockingQueue (bounded Q )
* Reject task: TP will reject task iof not space to store, based on policy
(Abortplocy,DiscardPolicy,DicardOlder,CAllerRunpolicy)
* alowcoreThreadTimeout(boolean) ;// if core thread pools size vary or not , default false
* service.shutdown():// it will initialte shutdown
*  service.isShutdown();/true if shutdonw
* service.isTermianted():// ture if all task is completed
* service.awaitTermination(10,Sec): // block until all ntask completed or timeout happen
* List<Runnable> alltask =service.shutdonwNow();

### Example
 * It has examples:
   - Getting price form different hotels and finding the min using Executor,CountdownLAtch and CompletableFuture.
   - Producer,Consumer : using in build ArrayBlockingQ and Also Custom Blocking Queue :)
   
                
  ### Java memory model:
Program: seres of statement,jvm may change the order of ur instruction to drive the prefformacne but the semantic of prog remain same.

#### Filed visibility:
 * mostly on concurrency
 * in case of multi core SPU arch.. each core have own reg,L1 cache.
 * L2 chache can eb shared between two core and then L3 cache cache will eb shared acorrss all the core ,and then RAM.
 * price vs performance: reg>L1 cache>L2 cache > L3 > RAM > 
 * Eg: if two thread update same value ,(both thread run on different core), so if T1 udate value ,it will be in its
 * L1 cache and and it has not pushed to the shared cache ,and T2 also read the value.. so inconsitent.
 * volatile: it is immeditly flushed the value from L1 to sahred as any modifictiation., so visibility.
 * So T2 will get updated value.
 * JMM: gurantee of reodfering and visibility of fields. , it informce all JVM has to implemet this.
 * synchroniz: if write happend before read(in diff thread), JMM will take care, if it is sync block.Also Sync has to applied on same object..
	 
### GET all active thread in java:
```xml
public class Main extends Thread {
   public static void main(String[] args) {
      Main t1 = new Main();
      t1.setName("thread1");
      t1.start();
      ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
      int noThreads = currentGroup.activeCount();
      Thread[] lstThreads = new Thread[noThreads];
      currentGroup.enumerate(lstThreads);
      
      for (int i = 0; i < noThreads; i++) 
	System.out.println("Thread No:" + i + " = " + lstThreads[i].getName());
   }
}
```
### JVM ARCHITECTURE:

<img src="jvm.png"
     alt="Markdown Monster icon"
     style="float: left; margin-right: 10px;" />
     
 ##### Class loader:
  Class loading: 
Loading :reads the .class file, generate the corresponding binary
Linking :Performs verification, preparation, and (optionally) resolution.
Initialization : n this phase, all static variables are assigned with their values defined

###### 3 class loaders: 
1 . Bootstrap class loader : Every JVM implementation must have a bootstrap class loader, capable of loading trusted classes. It loads core java API classes 
2 . Extension class loader : It is child of bootstrap class loader. It loads the classes present in the extensions directories JAVA_HOME/jre/lib/ext(Extension path)
3 . System/Application class loader : It is child of extension class loader. It is responsible to load classes from application class path


#### JVM Memory:
 Method area :In method area, all class level information like class name, immediate parent class name, methods and variables information etc
 Heap area :Information of all objects is stored in heap area. 
 Stack area :For every thread, JVM create one run-time stack which is stored here. Every block of this stack is called activation record/stack frame which store methods calls.
 PC Registers :Store address of current execution instruction of a thread. Obviously each thread has separate PC Registers.
 Native method stacks :For every thread, separate native stack is created. 


 ###### Execution Engine:
 Execution engine execute the .class (bytecode). It reads the byte-code line by line, use data and information present in various memory area and execute instructions.

 ###### classified in three parts :-
 1. Interpreter: the bytecode line by line and then executes. 
 2. Just-In-Time Compiler(JIT) :to increase efficiency of interpreter.
 3. Garbage Collector : It destroy un-referenced objects

 #### JNI:
 It is an interface which interacts with the Native Method Libraries and provides the native libraries(C, C++) required for the execution.


