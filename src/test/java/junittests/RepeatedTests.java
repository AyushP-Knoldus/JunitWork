package junittests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTests {

    @RepeatedTest(3)
    void repeatMethod(RepetitionInfo repetitionInfo) {
        System.out.println("Test repeated");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3 , () -> System.out.println(("This is repeating test")));
    }

    @RepeatedTest(value = 3 , name = "Repeating {currentRepetition} of {totalRepetitions}")
    @DisplayName("RepeatedTest")
    void repeatedMethodTwo() {
        System.out.println("Repeated method");
    }
}
