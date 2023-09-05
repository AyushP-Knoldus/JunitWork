package junittests;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedMethods2 {

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
    @Order(2)
    @DisplayName("TestOne - This displays test message")
    void firstTest() {
        System.out.println("This is first test.");
    }

    @Test
    @Order(3)
    void secondTest() {
        System.out.println("This is second test.");
    }

    @Test
    @Order(1)
    @DisplayName("TestThird")
    void thirdTest() { System.out.println("This is third test."); }
}
