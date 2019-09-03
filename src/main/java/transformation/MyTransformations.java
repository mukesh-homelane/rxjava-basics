package transformation;


import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

/**
 * Suppose you have some common transformations in multiple observables
 * so instead of writing the transformations to each observables
 * make an {@link ObservableTransformer#apply(Observable)} function like {@link MyTransformations#stringToInt()}
 * and using {@link Observable#compose(ObservableTransformer)} method assign the transformations into the Observable
 */
public class MyTransformations {
    public static void main(String[] args) {
        Observable<String> source1 = Observable.just("one","two","three","four","five");
        source1.compose(stringToInt())
                .subscribe(System.out::println);

        System.out.println("--------------------------");
        Observable<String> source2 = Observable.just("Mike","Ram","Shyam","Ghanshyam","Sam");
        source2.compose(stringToInt())
                .subscribe(System.out::println);

    }

    static ObservableTransformer<String, Integer> stringToInt(){
        return upstream -> upstream.map(s -> s.length()).filter(i -> i <= 3);
    }
}
