package junittests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JunitTest {

    @BeforeAll
    void beforeAll() {
        System.out.println("--This is Before All--");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("---This will run before every method---");
    }

    @AfterAll
    void afterAll() {
        System.out.println("--This is after all--");
    }

    @AfterEach
    void afterEach() {
        System.out.println("---This will run after each method---");
    }

    @Test
    @DisplayName("TestOne - This displays test message")
    void firstTest() {
        System.out.println("This is first test.");
    }

    @Test
    void secondTest() {
        System.out.println("This is second test.");
    }
}
