package combining_observables;

import io.reactivex.CompletableSource;
import io.reactivex.Observable;

public class MergeOperator {
    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("one", "one");
        Observable<String> source2 = Observable.just("two", "two");
        Observable<String> source3 = Observable.just("three", "three");
        Observable<String> source4 = Observable.just("four", "four");
        Observable<String> source5 = Observable.just("five", "five");

        /**
         * merge can merge upto 4 sources but for merging more sources use mergeArray
         * if you want to merge only 2 sources use Observable#mergeWith(Observable)
         * Note : merge may not maintain the order
         * if you want the order of the observable use {@link Observable#concat(Iterable)} or
         * {@link Observable#concatWith(CompletableSource)} operators
         */

//        Observable.merge(source1, source2, source3)
//                .distinct()
//                .subscribe(System.out::println);

        Observable.mergeArray(source1, source2, source3, source4, source5)
                .distinct()
                .subscribe(System.out::println);


    }
}
