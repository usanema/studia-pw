package com.pawer.pw.counter.impl;

import com.pawer.pw.counter.Counter;

public class SynchronizedCounter implements Counter {

    int value;

    @Override
    public synchronized void increment() {
        ++value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void reset() {
        value = 0;
    }
}
