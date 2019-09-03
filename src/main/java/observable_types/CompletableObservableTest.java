package observable_types;

import io.reactivex.Completable;

public class CompletableObservableTest {
    public static void main(String[] args) {

        /**
         * {@link Completable} has only 2 methods
         * {@link Completable#complete()} and
         * {@link Completable#error(Throwable)}
         */

        Completable.fromRunnable(() -> System.out.println("Calling onComplete"))
                .subscribe(() -> System.out.println("Complete"));
    }
}
