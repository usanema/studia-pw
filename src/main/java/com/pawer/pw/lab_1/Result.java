package com.pawer.pw.lab_1;

public record Result(
        long executionTimeNs,
        SimulationConfig config,
        int counterValue
) {
    @Override
    public String toString() {
        return String.format("| %-15s | %7d | %10d | %15d ns | %10d |",
                config.counterType(),
                config.threads(),
                config.ticketsPerThread(),
                executionTimeNs,
                counterValue);
    }

    public String toCsvRow() {
        return String.format("%s,%d,%d,%d,%d",
                config.counterType(),
                config.threads(),
                config.ticketsPerThread(),
                executionTimeNs,
                counterValue);
    }

    public static String getCsvHeader() {
        return "CounterType,Threads,TicketsPerThread,ExecutionTimeNs,FinalValue";
    }

    public static String getHeader() {
        return "| Counter Type    | Threads | Tickets/Thr | Exec Time       | Final Value |" + "\n" +
               "|-----------------|---------|-------------|-----------------|-------------|";
    }
}
