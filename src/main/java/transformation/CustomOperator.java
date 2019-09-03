package transformation;

import io.reactivex.Observable;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CustomOperator {
    public static void main(String[] args) {
        Observable.empty().cast(String.class).lift(defaultValue("test")).subscribe(System.out::println);
    }

    static ObservableOperator<String, String> defaultValue(String value){
        return new ObservableOperator<String, String>() {
            @Override
            public Observer<? super String> apply(Observer<? super String> observer) throws Exception {
                return new Observer<String>() {
                    boolean empty = true;
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        empty = false;
                        observer.onNext(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (empty){
                            observer.onNext(value);
                        }else {
                            observer.onComplete();
                        }
                    }
                };
            }
        };
    }
}
