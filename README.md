### EXECUTOR Example explanation:

 #### Executer 
* each java thred corrospond to one OS thread.
* CPU intensive" hashing or cryptographic/video alog..
* IO bound DB/netwrk/File
* if app is cup cound ,then nuomber of thread shud be equal to number of cores..
* 4 type of threadpool
   * Fixed threadpool, (in blocking Q and thread pick task form it)
   * CachedThread pool , Synchronous  Q ,kill htead if idle, can create any  umber of thread.
   * ScheduledThreadpool: kind of task that need to eb schduele(scurity check.log check evey 10 sec)
	 * service.scheduleAtFixedRAte and service.secheduelATFixedDelay
         * service.schedule(new TAsk(),10)
   * SingleThreadExecutor: same as fixedTP ,if thread is killed, it will recreate a new threas and execute
		 	*  when we want task 1 run before task 2 i.e sequential
 Executor service Argument adn API:
 

#### ExecuterService arguments:

 1 Core pool size.
 2 max pool size.
 3 Keep alive time(KAT): time after which the thread pool will kill the thread if idle.

* FixedThreadpool: core-size = max  and KAT os 0 sec ,LinkedClockingQueue
* CachedThread pool: 0 ,Integrer.MAX, 60 sec ,SynchronousQueue
* ScheduledThreadPool: arg,Interger.mac,60 ,DelayBlockQueue
* SingleThreadPool: 1,1,0sec LinkedBlockingQueue
* CustomeThreadpool: ArrayBlockingQueue (bounded Q )
* Reject task: TP will rejet task iof not space to store, based on policy(Abortplocy,DiscardPolicy,DicardOlder,CAllerRunpolicy)
* alowcoreThreadTimeout(boolean) ;// if core thread pools size vary or not , default false
* service.shutdown():// it will initialte shutdown
*  service.isShutdown();/true if shutdonw
* service.isTermianted():// ture if all task is completed
* service.awaitTermination(10,Sec): // block until all ntask completed or timeout happen
* List<Runnable> alltask =service.shutdonwNow();


                
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
	 
