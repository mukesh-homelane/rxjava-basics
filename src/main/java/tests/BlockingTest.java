package tests;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link Observable#blockingSubscribe()} will wait until the Observable has called onComplete
 * and it resumes the execution after that
 * As interval is an async function so we need to register it with blockingSubscribe()
 */
public class BlockingTest {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS).take(10);
        source.blockingSubscribe(i -> count.getAndIncrement());

        if (count.get() != 10)
            throw new RuntimeException("count value is not 10 it is : "+count.get());
        else
            System.out.println("Success");

        AtomicInteger count1 = new AtomicInteger(0);
        Observable<Long> source1 = Observable.interval(300, TimeUnit.MILLISECONDS).take(10);
        source1.subscribe(i -> count1.getAndIncrement());

        if (count1.get() != 10)
            throw new RuntimeException("count1 value is not 10 it is : "+count1.get());
        else
            System.out.println("Success1");
    }
}
