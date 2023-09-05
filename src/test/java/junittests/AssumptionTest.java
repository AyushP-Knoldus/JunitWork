package junittests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionTest {

    @ParameterizedTest(name = "Run: {index} -> {arguments}")
    @ValueSource(ints = {11,2,23})
    void paramsTest(int paramValue) {
        assumeTrue(paramValue < 5);
        System.out.println("The param values are ->" +paramValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"Mouse,5","Keyboard,2","Computer,7"})
    void csvParam(String product, int units) {
        Assumptions.assumeFalse(product.equals("Mouse"),"Product false at = "+product);
        System.out.println("product = " + product + ", units = " + units);
    }

    @ParameterizedTest
    @CsvSource(value = {"Mouse,5","Keyboard,2","Computer,7"})
    void csvParamAssumingThat(String product, int units) {
        Assumptions.assumingThat(units > 2, () -> System.out.println("This is working."));
        System.out.println("product = " + product + ", units = " + units);
    }
}
