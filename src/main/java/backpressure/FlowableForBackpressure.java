package backpressure;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * {@link Flowable} is used to handle back pressure
 * back pressure -> {@link io.reactivex.Observable} sending data in higher rate
 * which the {@link io.reactivex.Observer} cannot handle
 * so in back pressure scenario we use {@link Flowable} in place of {@link io.reactivex.Observable}
 */
public class FlowableForBackpressure {
    public static void main(String[] args) {
        Flowable.range(0, 500000)
                .doOnNext(System.out::println)
                .subscribeOn(Schedulers.computation())
        .subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                Sleep(200);
                System.out.println("onNext : "+integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        Sleep(10000);
    }

    static void Sleep(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
