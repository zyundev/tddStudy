package chep03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ExpiryDateCalculatorTest {

    @Test
    void pay_10000_won() {
        LocalDate bilingDate = LocalDate.of(2022,3,1);
        int payAmount = 10000;

        ExpiryDateCalculator expiryDateCalculator = new ExpiryDateCalculator();
        LocalDate expireDate = expiryDateCalculator.calculateExpiryDate(bilingDate, payAmount);

        assertEquals(LocalDate.of(2022,4,1), expireDate);

        LocalDate bilingDate2 = LocalDate.of(2022,5,1);
        int payAmount2 = 10000;

        ExpiryDateCalculator expiryDateCalculator2 = new ExpiryDateCalculator();
        LocalDate expireDate2 = expiryDateCalculator2.calculateExpiryDate(bilingDate2, payAmount2);

        assertEquals(LocalDate.of(2022,6,1), expireDate2);
    }
}
