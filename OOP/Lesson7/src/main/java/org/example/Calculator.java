package org.example;

public interface Calculator<T> {
    T add(T a, T b);
    T multiply(T a, T b);
    T divide(T a, T b);
}
