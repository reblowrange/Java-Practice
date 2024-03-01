package org.example.threads_two;

public class TestRunnable {

    /*
    * What is the difference between the start() and run() method of the Thread class?  (answer)
One of trick Java questions from early days, but still good enough to differentiate between shallow
* understanding of Java threading model start() method is used to start a newly created thread,
* while start() internally calls run() method, there is difference calling run() method directly.

* When you invoke run() as a normal method, it's called in the same thread, no new thread is started,
* which is the case when you call the start() method. Read this answer for a much more detailed discussion.
* */
    public static void main(String[] a) {
        Runnable r1 = () -> System.out.println("r1: " + Thread.currentThread().getName());
        Runnable r2 = () -> System.out.println("r1: " + Thread.currentThread().getName());
        r1.run(); // main thread
        r2.run(); // main thread
    }
}
