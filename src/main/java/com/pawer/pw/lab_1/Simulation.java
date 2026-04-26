package com.pawer.pw;

import com.pawer.pw.counter.Counter;
import com.pawer.pw.counter.CounterFactory;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

public class Simulation {

    private final SimulationConfig config;

    public Simulation(SimulationConfig config) {
        this.config = config;
    }

    public Result run() {
        Counter counter = CounterFactory.createCounter(config.counterType());
        Thread[] threads = new Thread[config.threads()];

        StopWatch timer = StopWatch.create();
        timer.start();

        // Manual thread creation and starting
        for (int i = 0; i < config.threads(); i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < config.ticketsPerThread(); j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Waiting for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        timer.stop();

        return new Result(
                timer.getNanoTime(),
                config,
                counter.getValue()
        );
    }
}
