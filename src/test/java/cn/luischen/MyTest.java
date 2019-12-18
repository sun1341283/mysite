package cn.luischen;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyTest {

    private final static Queue queue = MyQueue.instance();

    @Test
    public void provide(){
        queue.offer("1");
        System.out.println(queue);
    }

    @Test
    public void consume(){
        String a = null;
        while (true){
            if ((a = (String) queue.poll())!=null){
                System.out.println(a);
            }
        }
    }

    @Test
    public void print(){
        System.out.println(queue);
    }
}
