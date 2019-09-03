package operators;

import io.reactivex.Observable;

public class ActionOperator {
    public static void main(String[] args) {
        Observable.just(10,2,4,1,0,5,1,2)
                .doOnNext(e -> System.out.println("element "+e))
                .doOnComplete(() -> System.out.println("Completed"))
                .doOnError(e -> System.out.println("error has occured"))
                .map(i -> 5/i)
                .subscribe(System.out::println, e -> System.out.println(e));

    }
}
