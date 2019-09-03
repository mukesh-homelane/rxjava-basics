package conurrency;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class BlockingSubscribe {

    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .take(10)
                .blockingSubscribe(System.out::println,
                        throwable -> {},
                        ()-> System.out.println("Done 1"));

        Observable.interval(1000, TimeUnit.MICROSECONDS)
                .take(5)
                .blockingSubscribe(System.out::println,
                        throwable -> {},
                        ()-> System.out.println("Done 2"));
    }

}
