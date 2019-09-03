package operators;


import io.reactivex.Observable;

public class FilterOperator {
    public static void main(String[] args) {
        Observable<String> source = Observable.just("Mike","Shyam", "Ram", "Ghanshyam");
        source.filter(e -> e.length() <= 4)
                .subscribe(System.out::println);
    }
}
