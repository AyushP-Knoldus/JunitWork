package junittests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

    @ParameterizedTest(name = "Run: {index} -> {arguments}")
    @ValueSource(ints = {11,2,23})
    void paramsTest(int paramValue) {
        System.out.println("The param values are ->" +paramValue);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {"String1","String2"})
    void stringParam(String param) {
        System.out.println("The string values are ->" +param);
    }

    @ParameterizedTest
    @CsvSource(value = {"Mouse,5","Keyboard,2","Computer,7"})
    void csvParam(String product, int units) {
        System.out.println("product = " + product + ", units = " + units);
    }

    @ParameterizedTest
    @CsvSource(value = {"Ayush%Pathak","So%Hee"}, delimiter = '%')
    void csvDelimiter(String fName, String lName) {
        System.out.println("fName = " + fName + ", lName = " + lName);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/ProductList.csv"}, delimiter = '$',numLinesToSkip = 1)
    void csvFileDelimiter(String pName, int units, double price) {
        System.out.println("pName = " + pName + ", units = " + units + ", price = " + price);
    }

    @ParameterizedTest
    @MethodSource(value = "stringSource")
    void stringSourceMethod(String fruits) {
        System.out.println("fruits = " + fruits);
    }

    Stream<String> stringSource() {
        //Arrays.asList("Orange","Apple","Lemon")
        return Stream.of("Orange","Apple","Lemon");
    }

    @ParameterizedTest
    @MethodSource(value = "stringIntSource")
    void stringIntSourceMethod(String name, int values) {
        System.out.println("name = " + name + ", values = " + values);
    }
    List<Arguments> stringIntSource() {
        return Arrays.asList(Arguments.arguments("Ayush",2),Arguments.arguments("Rahul",3));
    }
}
