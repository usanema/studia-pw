package com.pawer.pw.lab_1;

import com.pawer.pw.lab_1.counter.CounterFactory;

public record SimulationConfig(
        int threads,
        int ticketsPerThread,
        CounterFactory.CounterType counterType
) {
}
