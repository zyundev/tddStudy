package chep02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    /**
     * 첫번째 테스트
     */
    @Test
    void meetsAllCriteria_Then_Strong() {
        //PasswordStrengthMeter meter = new PasswordStrengthMeter(); 중복제거
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
    }

    /**
     * 두번째 테스트
     */
    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        //PasswordStrengthMeter meter = new PasswordStrengthMeter(); 중복제거
        PasswordStrength result = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    /**
     * 세번째 테스트
     */
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        //중복제거
        //PasswordStrengthMeter meter = new PasswordStrengthMeter();
        //PasswordStrength result = meter.meter("ab!@ABsdre");
        //assertEquals(PasswordStrength.NORMAL, result);
        assertStrength("ab!@ABsdre", PasswordStrength.NORMAL);
    }

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr, result);
    }

    /**
     * 네번째 테스트
     */
    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    /**
     * 다섯번째 테스트
     */
    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStrength.NORMAL);
    }

    /**
     * 여섯번째 테스트
     */
    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefgre", PasswordStrength.WEAK);
    }

    /**
     * 일곱번째 테스트
     */
    @Test
    void meetsOnlyNumCriteria_Then_Weak() {
        assertStrength("123456", PasswordStrength.WEAK);
    }

    /**
     * 여덟번째 테스트
     */
    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        assertStrength("NEEDTDD", PasswordStrength.WEAK);
    }
}
