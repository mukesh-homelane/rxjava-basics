package observable_types;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleObservableTest {
    public static void main(String[] args) {

        /**
         * Single is just an observer with only one value
         * it don't have {@link io.reactivex.Observer#onNext}
         */
        SingleObserver<String> observer = new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }
        };

        // example
        Observable.just("a", "b").first("*").subscribe(System.out::println);

        //this will output 'a' but the important thing to observer here is
        // .first operator will return a Single type Observable
    }
}
