package com.goura.copilot.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class JUnitDemoUtils {
    private String[] names = new String[] {"Alice", "Bob", "Charlie", "David"};
    private List<String> nameList = List.of("Alice", "Bob", "Charlie", "David");

    public String[] getNames() {
        return names;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public String sleepForSometime(int duration) throws InterruptedException {
        TimeUnit.SECONDS.sleep(duration);
        return String.format("Slept for %d seconds", duration);
    }

    public int devide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }
}
