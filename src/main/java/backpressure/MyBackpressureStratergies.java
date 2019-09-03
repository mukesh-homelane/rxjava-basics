package backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.exceptions.MissingBackpressureException;

/**
 * {@link Flowable#range(int, int)} implements the backpressure itself
 * but if you are using {@link Flowable#create(FlowableOnSubscribe, BackpressureStrategy)}
 * you need to implement your own {@link BackpressureStrategy}
 * {@link BackpressureStrategy} types :
 *      - {@link BackpressureStrategy#BUFFER} : Buffers <em>all</em> onNext values until the downstream consumes it.
 *      - {@link BackpressureStrategy#DROP} : Drops the most recent onNext value if the downstream can't keep up
 *      - {@link BackpressureStrategy#LATEST} : Keeps only the latest onNext value, overwriting any previous
 *                  value if the downstream can't keep up
 *      - {@link BackpressureStrategy#ERROR} : Signals a {@link MissingBackpressureException} in case the downstream can't keep up.
 *      - {@link BackpressureStrategy#MISSING}
 *
 */
public class MyBackpressureStratergies {
    public static void main(String[] args) {
        Flowable source = Flowable.create(subscriber ->{
            subscriber.onNext("Black");
            subscriber.onNext("White");
        }, BackpressureStrategy.BUFFER);
    }
}
