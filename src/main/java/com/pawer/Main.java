package com.pawer;

import com.pawer.pw.lab_1.BenchmarkSuite;

public class Main {

    public static void main(String[] args) {
        BenchmarkSuite suite = new BenchmarkSuite();
        for (int i = 0; i < 10 ; i++) {
            suite.runSuite(BenchmarkSuite.SuiteType.MAX_PHYSICAL_THREADS);
        }
    }
}

/**
 * SYNCHRONIZED - 1660166
 * ATOMIC - 1278458
 */
