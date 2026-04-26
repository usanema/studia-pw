package com.pawer.pw;

import com.pawer.pw.counter.CounterFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkSuite {

    public enum SuiteType {
        BASE(8),
        MAX_PHYSICAL_THREADS(24);

        private final int threads;
        SuiteType(int threads) { this.threads = threads; }
        public int getThreads() { return threads; }
    }

    private static final List<Integer> TICKET_COUNTS = List.of(10, 100, 1000, 10000, 1000000);

    public List<Result> runSuite(SuiteType suiteType) {
        List<SimulationConfig> configs = new ArrayList<>();

        List<Integer> threadCounts = List.of(suiteType.getThreads());

        for (int threads : threadCounts) {
            for (int tickets : TICKET_COUNTS) {
                for (CounterFactory.CounterType type : CounterFactory.CounterType.values()) {
                    configs.add(new SimulationConfig(threads, tickets, type));
                }
            }
        }

        System.out.println("\nRunning Suite: " + suiteType);
        System.out.println(Result.getHeader());
        
        return configs.stream()
                .map(config -> new Simulation(config).run())
                .peek(System.out::println)
                .toList();

    }

    public void saveToCsv(List<Result> results, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(Result.getCsvHeader());
            results.forEach(r -> writer.println(r.toCsvRow()));
            System.out.println("\nResults saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving to CSV: " + e.getMessage());
        }
    }
}
