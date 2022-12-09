package org.example.passwordCheck;

//테스트 후 리펙토링이 끝나면 src.main.java에 옮기는 것으로 마무리함 
public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        //네번째 테스트
        if (s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }
        int metCounts = getMetCriteriaCounts(s);
        //아홉번째 테스트
        if (metCounts <= 1) return PasswordStrength.WEAK;
        if (metCounts == 2) return PasswordStrength.NORMAL;

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

    public int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        //여섯번째 테스트
        if (s.length() >= 8) metCounts++;
        //일곱번째 테스트
        if (meetsContainingNumberCriteria(s)) metCounts++;
        //여덟번째 테스트
        if (meetsContainingUppercaseCriteria(s)) metCounts++;

        return metCounts;
    }
}
