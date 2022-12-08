package chep02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        //네번째 테스트
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        //여섯번째 테스트
        boolean lengthEnough = s.length() >= 8;
        boolean containsNumber = meetsContainingNumberCriteria(s);
        boolean containsUpper = meetsContainingUppercaseCriteria(s);

        if (lengthEnough && !containsNumber && !containsUpper) {
            return PasswordStrength.WEAK;
        }
        //일곱번째 테스트
        if (!lengthEnough && containsNumber && !containsUpper) {
            return PasswordStrength.WEAK;
        }
        //여덟번째 테스트
        if (!lengthEnough && !containsNumber && containsUpper) {
            return PasswordStrength.WEAK;
        }

        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        //두번째 테스트
        //if (s.length() < 8) {
        //    return PasswordStrength.NORMAL;
        //}
        //세번째 테스트
        //boolean containsNumber = false;
        //for (char c: s.toCharArray()) {
        //    if (c >= '0' && c <= '9') {
        //        containsNumber = true;
        //        break;
        //    }
        //} -> 메소드로 리팩토링
        if (!containsNumber) {
            return PasswordStrength.NORMAL;
        }
        //다섯번째 테스트
        //boolean containsUpp = false;
        //for (char c: s.toCharArray()) {
        //    if (Character.isUpperCase(c)){
        //        containsUpp = true;
        //        break;
        //    }
        //} -> 메소드로 리팩토링
        if (!containsUpper) {
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

    public boolean meetsContainingUppercaseCriteria(String s) {
        for (char c: s.toCharArray()) {
            if (Character.isUpperCase(c)){
                return true;
            }
        }
        return false;
    }
}
