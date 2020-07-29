package com.example.legacylogictest.loop;


import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class LoopTest {

	final int LOOP_LIMIT = 100000;
	List<Integer> array = new ArrayList<>();

	@Setup
	public void init() {
		for(int loop = 0; loop < LOOP_LIMIT; loop++) {
			array.add(loop);
		}
	}

	@Benchmark
	public void originLoopWithGetSize() {
		for (int loop = 0; loop < array.size(); loop++) {
			process(array.get(loop));
		}
	}

	@Benchmark
	public void originLoop() {
		int listSize = array.size();
		for (int loop = 0; loop < listSize; loop++) {
			process(array.get(loop));
		}
	}

	@Benchmark
	public void forEach() {
		int listSize = array.size();
		for( Integer x: array ) {
			process(x);
		}
	}

	@Benchmark
	public void forEachByJdk8() {
		array.forEach(x -> process(x));
	}

	@Benchmark
	public void forEachByStream() {
		array.stream().forEach(x -> process(x));
	}

	private int temp = 0;
	public void process(int a) {
		System.out.println("aaa");
		temp+=a;
	}
}
