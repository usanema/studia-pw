package com.pawer.pw;

import com.pawer.pw.counter.CounterFactory;

public record SimulationConfig(
        int threads,
        int ticketsPerThread,
        CounterFactory.CounterType counterType
) {
}
