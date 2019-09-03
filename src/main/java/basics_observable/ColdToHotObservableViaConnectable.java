package basics_observable;


import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.Arrays;
import java.util.List;

public class ColdToHotObservableViaConnectable {
    public static void main(String[] args) {

        /**
         * If you know the number of Observers from the start
         * use {@link Observable#publish()#autoConnect([n])} n is the number of subscribers
         * for example see at bottom
         */
        List<String> arrays = Arrays.asList("one", "two", "three", "four", "five");
        Observable<String> cold = Observable.fromIterable(arrays);

        // this will convert (cold observable -> hot observable)
        ConnectableObservable<String> hot = cold.publish();

        hot.subscribe(e -> System.out.println("observer 1 "+e));
        hot.subscribe(e -> System.out.println("observer 2 "+e));

        //this will trigger the Observer#onNext()
        hot.connect();

        System.out.println("---------------------------");
        Observable<String> s = Observable.fromIterable(arrays).publish().autoConnect(2);
        s.subscribe(i -> System.out.println("operator 1 "+i));
        s.subscribe(i -> System.out.println("operator 2 "+i));
    }
}

