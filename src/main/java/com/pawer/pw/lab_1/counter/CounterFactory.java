package com.pawer.pw.lab_1.counter;


import com.pawer.pw.lab_1.counter.impl.AtomicCounter;
import com.pawer.pw.lab_1.counter.impl.SynchronizedCounter;
import com.pawer.pw.lab_1.counter.impl.UnsafeCounter;

public class CounterFactory {

    public enum CounterType {
        NO_THREAD_SAFE,
        SYNCHRONIZED,
        ATOMIC
    }


    public static Counter createCounter(CounterType type) {
        return switch (type) {
            case NO_THREAD_SAFE -> new UnsafeCounter();
            case SYNCHRONIZED -> new SynchronizedCounter();
            case ATOMIC -> new AtomicCounter();
            default -> throw new IllegalArgumentException("Unsupported counter type");
        };
    }
}
