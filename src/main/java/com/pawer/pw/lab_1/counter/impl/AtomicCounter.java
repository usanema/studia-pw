package com.pawer.pw.lab_1.counter.impl;

import com.pawer.pw.lab_1.counter.Counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

    private final AtomicInteger value = new AtomicInteger();

    @Override
    public void increment() {
        value.incrementAndGet();
    }

    @Override
    public int getValue() {
        return value.get();
    }

    @Override
    public void reset() {
        value.set(0);
    }
}
