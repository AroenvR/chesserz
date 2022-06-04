package com.breaker.chesserz.util;

/**
 * Optional class for handling null values, parts taken from the Java 8 Optional class.
 * https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 * @param <T> - the type of the object
 */
public class Optional<T> {
    private final T value;

    public Optional(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<T>(value);
    }

    public static <T> Optional<T> empty() {
        return new Optional<T>(null);
    }

}
