package tests;

import java.util.ArrayList;
import java.util.List;

public class SyncTest {
    public static void main(String[] args) {

        Test test = new Test();
        System.out.println("the start");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
                test.addAVal(1);
                test.addAVal(2);
                test.addAVal(3);
                test.read();
                test.addAVal(4);
                test.addAVal(5);
                test.addAVal(5);
                test.addAVal(5);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
                test.addAVal(-1);
                test.addAVal(-2);
                test.addAVal(-3);
                test.read();
            }
        });
        t1.start();
        t2.start();
        System.out.println("the end");
    }
}

class Test {
    List<Integer> list = new ArrayList();

    public void addAVal(Integer i){
        list.add(i);
        System.out.println("adding value : "+i);
    }

    void read(){
        System.out.println("entering into synchronized block");
        synchronized (list){
            System.out.println("starting");
            for (Integer i :
                    list) {
                System.out.println("value "+i);
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ending");
        }
    }

}
