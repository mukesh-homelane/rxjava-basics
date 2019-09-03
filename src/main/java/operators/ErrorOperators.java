package operators;

import io.reactivex.Observable;

public class ErrorOperators {
    public static void main(String[] args) {
        Observable.just(1,2,10,5,10,9,0)
                .map(e -> 5/e)
                .onErrorReturnItem(-1)
                .subscribe(System.out::println);

        System.out.println("----------------");
        Observable.just(1,2,10,5,10,9,0)
                .map(e -> 5/e)
                .onErrorResumeNext(Observable.just(1,1,1))
                .subscribe(System.out::println);


    }
}
