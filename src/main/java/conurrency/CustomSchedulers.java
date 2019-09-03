package conurrency;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomSchedulers {
    public static void main(String[] args) {
        // if you want to create your own custom Schedulers you can create it using ExecutorService
        ExecutorService service = Executors.newSingleThreadExecutor();
        Scheduler schedulers = Schedulers.from(service);

        Observable source = Observable.just("one","two","three","four","five")
                .subscribeOn(schedulers);   // using your custom schedulers

        source.subscribe(d -> {System.out.println(d+" : 1"); System.out.println(LocalTime.now());},
                throwable -> {},
                () -> {
                    Schedulers.shutdown();
                    service.shutdown();
                    System.out.println("onComplete");
        });
        System.out.println("Done");

    }
}
