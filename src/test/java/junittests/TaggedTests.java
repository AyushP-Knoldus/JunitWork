package junittests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTests {

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
    @Tag("sanity")
    @DisplayName("TestOne - This displays test message")
    void firstTest() {
        System.out.println("This is first test.");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    void secondTest() {
        System.out.println("This is second test.");
    }

    @Test
    @Tag("acceptance")
    void thirdTest() {
        System.out.println("Third test");
    }
}
