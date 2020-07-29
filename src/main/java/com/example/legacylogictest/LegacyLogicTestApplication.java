package com.example.legacylogictest;

import com.example.legacylogictest.loop.LoopTest;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

public class LegacyLogicTestApplication {

	public static void main(String[] args) throws IOException, RunnerException {
		Options opt = new OptionsBuilder()
				.include(LoopTest.class.getSimpleName())
				.warmupIterations(10)
				.measurementIterations(10)
				.forks(1)
				.build();
		new Runner(opt).run();
	}

}
