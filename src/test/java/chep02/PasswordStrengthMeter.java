package chep02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        //두번째 테스트
        if (s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        //세번째 테스트
        //boolean containsNumber = false;
        //for (char c: s.toCharArray()) {
        //    if (c >= '0' && c <= '9') {
        //        containsNumber = true;
        //        break;
        //    }
        //} -> 메소드로 리팩토링
        boolean containsNumber = meetsContainingNumberCriteria(s);
        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    public boolean meetsContainingNumberCriteria(String s) {
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }
}
