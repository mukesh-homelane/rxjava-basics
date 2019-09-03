package observable_types;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;

public class MaybeObservableTest {
    public static void main(String[] args) {

        /**
         * the maybe observer may or may not return a value
         * for example :
         * when you use filter operator it will give you a MaybeObserver
         * i.e. you may or may-not get the value while filtering
         * and {@link MaybeObserver#onComplete()} will let you know the filtering process is done
         * and you didn't get any value
         */
        MaybeObserver<String> s = new MaybeObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
