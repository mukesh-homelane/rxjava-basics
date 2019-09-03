package basics_observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

import java.util.Arrays;
import java.util.List;

public class ColdObservable {
    public static void main(String[] args) {

        Observable<String> source = Observable.create(emmiter -> {
           try {
               emmiter.onNext("First");
               emmiter.onNext("Second");
               emmiter.onNext("Third");
               emmiter.onComplete();
           } catch (Exception e){
               emmiter.onError(e);
           }
        });

        /**
         * {@link Observable#just(Object)} and
         * {@link Observable#fromIterable(Iterable)} gives a cold Observable
         */
        Observable<String> source2 = Observable.just("0ne", "Two", "Three");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Subscribed");
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Completely observed all the events");
            }
        };

//        source.subscribe(observer);

        /**
         * shorthand expression
         * System.out::println i.e. (val) -> {System.out.println(val)}
         * {@link Observable#subscribe(Consumer, Consumer, Action)}
         * the first parameter is {@link Observer#onNext(Object)}
         * the second parameter is {@link Observer#onError(Throwable)}
         * the third parameter is {@link Observer#onComplete()}
         */
        source2.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Completely observed from first"));

        source2.subscribe(e -> System.out.println("Observer 2 : "+e),
                Throwable::printStackTrace,
                () -> System.out.println("Completely observed from second"));

        /**
         * As {@link Observable#just(Object)} gives cold observable
         * so the Output of the following code will be
         * -----------------------------------------
         * First
         * Second
         * Third
         * Completely observed from first
         * Observer 2 : First
         * Observer 2 : Second
         * Observer 2 : Third
         * Completely observed from second
         */

        System.out.println("----------from Iterable --------------");
        List<String> arrays = Arrays.asList("1","2","3","4");
        Observable<String> iterableObserver = Observable.fromIterable(arrays);

        iterableObserver.subscribe(e -> System.out.println("observer 1 "+e));
        iterableObserver.subscribe(e -> System.out.println("observer 2 "+e));
        // this will behavior as same as just as it's a cold observable

    }
}
