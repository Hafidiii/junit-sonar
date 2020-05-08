package com.example.test.config;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

//TestInstance -> PER_METHOD : (default type) Junit instantiate the test class as many times as the number of test method
@DisplayName("MathUtilsTest TEST CLASS")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MathUtilsTest.class);
    private MathUtils mathUtils;

    @BeforeAll
    void init() {
        /*
         * @BeforeAll et @AfterAll all methods with those annotations have to be static (if TestInstance is per method) and gets
         * executed before/after all test methods
         */
        //LOGGER.info("--------------- init test case ----------------");
        mathUtils = new MathUtils();
    }


    @BeforeEach
    void setUp() {
        //@BeforeEach et @AfterEach all methods with those annotations gets executed before/after test method
        LOGGER.info("--------------- setup test case ----------------");
    }

    @Nested
    @DisplayName("ADD TEST CLASS")
    class testAdd {
        @Test
        @DisplayName("Add POSITIVE numbers method")
        void testAddPositive() {
            //assertEquals(4, mathUtils.add(1, 3), "The add method should add two numbers");
            assertEquals(4, mathUtils.add(1, 3), () -> "The add method should add two numbers");
        }

        @Test
        @DisplayName("Add NEGATIVE numbers method")
        void testAddNegative() {
            assertEquals(-4, mathUtils.add(-1, -3), "The add method should add two numbers");
        }
    }


    @Test
    //@RepeatedTest(3)
    @DisplayName("Division method")
    void testDevide() {
        //LOGGER.info("you can get all info about the current repeated test -> {}", repetitionInfo);
        //org.assertj.core.api.Assumptions.assumeThat(repetitionInfo.getCurrentRepetition() != 1);
        assertAll(
                () -> assertDoesNotThrow(() -> mathUtils.devide(2, 0)),
                () -> assertEquals(4, mathUtils.devide(8, 2))
        );

    }


    @Test
    @DisplayName("Multiply method")
    void testMultiply(TestInfo testInfo, TestReporter testReporter) {
        testReporter.publishEntry(testInfo.getDisplayName() + " " + testInfo.getTestMethod());
        assertAll(
                () -> assertEquals(6, mathUtils.multiply(2, 3)),
                () -> assertEquals(0, mathUtils.multiply(0, 3)),
                () -> assertEquals(-8, mathUtils.multiply(-2, 4))
        );


    }
}