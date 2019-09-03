package combining_observables;

import io.reactivex.Observable;

public class ZipOperator {
    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("one","two","three","four");
        Observable<String> source2 = Observable.just("1","2","3");

        Observable.zip(source1, source2, (s1, s2) -> s1+"-"+s2)
                .subscribe(System.out::println);
    }
}
