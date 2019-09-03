package operators;

import io.reactivex.Observable;

public class TakeSkipFirst {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Mike","Shyam", "Ram", "Ghanshyam");
        source.take(2)
                .subscribe(System.out::println);

        System.out.println("------------------");
        source.skip(2)
                .subscribe(System.out::println);

        System.out.println("------------------");
        source.first("default")
                .subscribe(System.out::println);
    }
}
