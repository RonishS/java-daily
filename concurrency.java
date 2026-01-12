//Concurrency In java 
/* Concurrency allows multiple tasks to run in parallel to improve performance and CPU utilization*/

//Multi Threading
/* A thread is a lightweight sub process, java supports multi threading using thread class and runnable interfaces 
 * 
 * 	Thread Priority 
 * 	MIN_PRIORITY (Low)
	NORM_PRIORITY (Normal – default)
	MAX_PRIORITY (High)
	
*Exam Question: Why should thread priority be set?

Answer (write this):
Thread priority is set to control the execution order of threads and reduce thread misalignment, ensuring that more important tasks get CPU time before less important ones.*/


//Syncronization(Thread Communication0
/* used to avoid data inconsistency,ensures only one thread access shared resources at time 
 * 	Achieved using:

synchronized methods

synchronized blocks


//sleep() Method
Pauses execution of current thread for specified time
Helps in thread coordination
Does NOT release lock

Thread.sleep(1000);


join() Method (⭐ Important)
Used to wait for another thread to complete
Helps maintain execution order

thread.join();

*/

