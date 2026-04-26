package com.pawer.pw.counter.impl;

import com.pawer.pw.counter.Counter;

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
