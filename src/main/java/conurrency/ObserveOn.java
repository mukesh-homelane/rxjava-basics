package conurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;

public class ObserveOn {
    public static void main(String[] args) {
        Observable source = Observable.just("one","two","three","four","five")
                .subscribeOn(Schedulers.computation());

        source.subscribe(d -> {System.out.println(d+" : 1");
            System.out.println(LocalTime.now());});
        source.subscribe(d -> {System.out.println(d);
            System.out.println(LocalTime.now());});
        source.observeOn(Schedulers.io());  // this will continue the Observable on io Schedulers
        // io Schedulers is used for file read-write, network operations, database operations

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
