package disposables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class FromCompositeDisposable {
    public static void main(String[] args) {

        /**
         * {@link io.reactivex.disposables.CompositeDisposable} will dispose all the observables at once
         */
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);

        Disposable disposable1 = observable.subscribe(e -> System.out.println(e));
        Disposable disposable2 = observable.subscribe(e -> System.out.println(e));

        // registering disposables in composite disposable
        compositeDisposable.addAll(disposable1, disposable2);

        // dispose all the disposables
        compositeDisposable.dispose();

    }
}
