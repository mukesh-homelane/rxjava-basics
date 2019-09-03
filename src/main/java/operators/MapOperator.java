package operators;

import io.reactivex.Observable;

/**
 * The map operator is used to transform the Observable from one kind to other kind
 * In this example the Observable<String> is transformed to Observable<Integer>
 */

public class MapOperator {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Ram","Shyam");
        source.map(e -> e.length())
                .subscribe(System.out::println);
    }
}
