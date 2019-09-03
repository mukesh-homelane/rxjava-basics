package combining_observables;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.Random;

public class FlatmapOperator {
    static int i = 1;
    public static void main(String[] args) throws InterruptedException {

        // the flatmap will create an observable for each character
        // i.e. 15 observables as 5*3 = 15
        // in Flatmap the order is not maintained
        // if you want to maintain order use concatMap in place of flatMap
        // Concatmap() operator must wait for the previous object to be emitted before moving onto the next
        System.out.println(Thread.currentThread());
        Observable.just("abcde", "efghi","jklmn")
                .flatMap(e -> {
                    Thread.sleep(new Random().nextInt(5)*1000);
                    System.out.println(Thread.currentThread());
                    return Observable.fromArray(e.split(""));}
                ).subscribeOn(Schedulers.computation())
                .subscribe(e -> {
                    System.out.println(i++);
                    System.out.println(e);
                });
        Thread.sleep(15000);
        System.out.println(Thread.currentThread());
    }
}
