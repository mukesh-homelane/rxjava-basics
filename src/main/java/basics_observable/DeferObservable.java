package basics_observable;


import io.reactivex.Observable;

import java.util.concurrent.Callable;

public class DeferObservable {
    static int a = 0, b = 5;
    public static void main(String[] args) {

        /**
         * {@link Observable#defer(Callable)} postpones the result
         * until an observer subscribe to it
         * Note: There will be multiple copies of observables
         */

        Observable<Integer> source = Observable.defer(() -> Observable.range(a,b));
        source.subscribe(System.out::println);
        b = 10;
        source.subscribe(e -> System.out.println("observer 2 "+e));

        /**
         * output
         * ---------
         * 0
         * 1
         * 2
         * 3
         * 4
         * observer 2 0
         * observer 2 1
         * observer 2 2
         * observer 2 3
         * observer 2 4
         * observer 2 5
         * observer 2 6
         * observer 2 7
         * observer 2 8
         * observer 2 9
         */
    }
}
