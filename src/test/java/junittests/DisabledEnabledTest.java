package junittests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;

public class DisabledEnabledTest {

    @Test
    @Disabled(value = "Disabled with @Disabled")
    void firstMethod() {
        System.out.println("This is first method");
    }

    @Test
    @DisabledOnOs(value = OS.LINUX , disabledReason = "Disable for linux Systems")
    void secondMethod() {
        System.out.println("This is second method");
    }

    @Test
    @DisabledIf(value = "dayMethod", disabledReason = "Disable for tuesday")
    void thirdMethod() {
        System.out.println("This is third method");
    }

    boolean dayMethod() {
        return OffsetDateTime.now().getDayOfWeek().equals(DayOfWeek.TUESDAY);
    }
}
