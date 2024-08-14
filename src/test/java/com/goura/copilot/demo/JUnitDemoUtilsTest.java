package com.goura.copilot.demo;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)
class JUnitDemoUtilsTest {

    private JUnitDemoUtils utils = new JUnitDemoUtils();

    @Test
    @DisplayName("Get names as array")
    @EnabledForJreRange(min = JRE.JAVA_14, max = JRE.JAVA_21)
    void getNamesAsArray() {
        String[] names = new String[] {"Alice", "Bob", "Charlie", "David"};
        assertArrayEquals(names, utils.getNames());
    }

    @Test
    @DisplayName("Get names as list")
    @EnabledOnOs(OS.MAC)
    void getNamesAsList() {
        List<String> nameList = List.of("Alice", "Bob", "Charlie", "David");
        assertLinesMatch(nameList, utils.getNameList());
        assertIterableEquals(nameList, utils.getNameList());
    }

    @Test
    @DisplayName("Test Timeout")
    @EnabledOnJre(JRE.JAVA_17)
    void testTimeout() {
        assertTimeoutPreemptively(
                Duration.ofSeconds(3),
                () -> utils.sleepForSometime(2),
                "Execution took more than 3 seconds"
        );
    }

    @Test
    @DisplayName("Test Throws and Does Not Throw")
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void testThrowsAndDoesNotThrow() {
        assertDoesNotThrow(() -> utils.devide(10, 2));
        assertThrows(IllegalArgumentException.class, () -> utils.devide(10, 0));
    }

    @Test
    @DisplayName("Dummy Test")
    public void dummyTest() {
        assertTrue(1 == 1);
    }
}