package com.pawer.pw.lab_1.counter.impl;

import com.pawer.pw.lab_1.counter.Counter;

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
