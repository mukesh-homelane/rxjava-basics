package backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class FLowableObservableInterconvertion {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("one", "two", "three");

        // convert Observable to Flowable
        Flowable flowable = observable.toFlowable(BackpressureStrategy.LATEST);

        // convert Flowable to Observable
        Observable newObservale = flowable.toObservable();
    }
}
