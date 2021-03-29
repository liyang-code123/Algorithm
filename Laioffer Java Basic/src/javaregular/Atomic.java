/*
The volatile keyword is guaranteed visibility(semantically, happens-before), much like acquiring and releasing a lock.
common use case - flag to stop(a signal from outside the running thread)
Atomicity:
When a thread modifies the state of some object(or set of objects), another thread can't see any intermediary state.
Either it sees the state as it was before the operation, or it seems the state as it is after the operation.
Atomic 是指一个操作是不可中断的。即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰。
 */

package javaregular;

public class Atomic {
    public static volatile boolean flag = false;
    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (!flag) {
                // try another way to see what happens if comment out System.out.
//                System.out.println("The thread is running...");
                i++;
            }
            System.out.println("The thread is finished...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new MyRunnable());
        newThread.start();
        Thread.sleep(1000);
        flag = true;
        System.out.println("Main thread is finished...");
    }
}
