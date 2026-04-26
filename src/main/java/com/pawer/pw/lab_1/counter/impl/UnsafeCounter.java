package com.pawer.pw.lab_1.counter.impl;

import com.pawer.pw.lab_1.counter.Counter;

public class UnsafeCounter implements Counter {

    private int value;

    @Override
    public void increment() {
        ++value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void reset() {
        value = 0;
    }
}
