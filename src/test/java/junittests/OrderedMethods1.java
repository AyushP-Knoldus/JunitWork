package junittests;

import listeners.Listener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

//@TestMethodOrder(MethodOrderer.MethodName.class)
@ExtendWith(Listener.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedMethods1 {

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

    @Test
    @DisplayName("TestThird")
    void thirdTest() { System.out.println("This is third test."); }
}
