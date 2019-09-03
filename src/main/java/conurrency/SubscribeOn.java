package conurrency;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;

public class SubscribeOn {
    public static void main(String[] args) {
        Observable source = Observable.just("one","two","three","four","five")
                .subscribeOn(Schedulers.computation());

        source.subscribe(d -> {System.out.println(d+" : 1");
            System.out.println(LocalTime.now());});
        source.subscribe(d -> {System.out.println(d);
            System.out.println(LocalTime.now());});

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
