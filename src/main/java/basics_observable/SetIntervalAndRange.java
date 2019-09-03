package basics_observable;


import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class SetIntervalAndRange {
    public static void main(String[] args) {

        Observable.interval(200, TimeUnit.MILLISECONDS).subscribe(System.out::println);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------Range ---------------");
        Observable.range(0,9).subscribe(System.out::println);

    }
}
