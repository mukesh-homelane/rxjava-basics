package backpressure;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

/**
 * As {@link Flowable#interval(long, TimeUnit)} is a time bounded operation
 * you cannot directly apply {@link BackpressureStrategy}
 * so you have to use operator with the flowable to handle backpressure
 */
public class BackPressureOperator {
    public static void main(String[] args) {
        Flowable source = Flowable.interval(1, TimeUnit.SECONDS);
        source.onBackpressureBuffer(10,() -> System.out.println("Overflow"), BackpressureOverflowStrategy.DROP_LATEST);

        // this will take only the latest
        source.onBackpressureLatest();
        source.onBackpressureDrop();
    }
}
