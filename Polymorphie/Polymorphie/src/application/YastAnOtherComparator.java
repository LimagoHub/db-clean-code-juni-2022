package application;

public interface YastAnOtherComparator<T> {
    boolean lessThen(T a, T b);
    boolean equal(T a, T b);

    default boolean le(T a, T b) {
        return lessThen(a,b ) || equal(a, b);
    }

    boolean moveNext() ;

    default void moveLast() {
        while(moveNext());
    }

}
