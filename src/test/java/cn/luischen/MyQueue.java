package cn.luischen;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {
    private static BlockingQueue queue = new LinkedBlockingDeque();

    public static Queue instance (){
        return queue;
    }

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(Thread.currentThread().getName()+"take"+queue.take());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(Thread.currentThread().getName()+"take"+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(runnable);
        service.submit(runnable);
        service.submit(runnable);
        //service.submit(runnable);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        queue.put(String.valueOf(i.getAndAdd(1)));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        queue.put(String.valueOf(i.getAndAdd(1)));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        queue.put(String.valueOf(i.getAndAdd(1)));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        queue.put(String.valueOf(i.getAndAdd(1)));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        queue.put(String.valueOf(i.getAndAdd(1)));
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
