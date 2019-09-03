package disposables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class FromObserver {
    public static void main(String[] args) {

        /**
         * if you want to dispose from observer
         * keep a reference of {@link Disposable} from {@link Observer#onSubscribe(Disposable)}
         * and when you want to dispose the observer then call {@link Disposable#dispose()}
         */

        Observer<Integer> observer = new Observer<Integer>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(Integer o) {

            }

            @Override
            public void onError(Throwable e) {
                disposable.dispose();
            }

            @Override
            public void onComplete() {
                disposable.dispose();
            }
        };
    }
}
