## 테스트 작성 순서 연습

1. 서비스를 사용하려면 매달 만원을 선불로 납부
2. 납부일 기준으로 한 달 뒤가 서비스 만료일임
3. 2개월 이상 요금을 납부할 수 있음
4. 10만원 납부시 서비스로 1년 제공

### 쉬운 것부터 테스트
- 구현하기 쉬운것부터 테스트
- 예외 상황을 먼저 테스트

```java
//만원 납부하면 한달 뒤 만료되는 테스트
@Test
void pay_10000_won() {
    LocalDate bilingDate = LocalDate.of(2022,3,1);
    int payAmount = 10000;
    ExpiryDateCalculator expiryDateCalculator = new ExpiryDateCalculator();
    LocalDate expireDate = expiryDateCalculator.calculateExpiryDate(bilingDate, payAmount);
    assertEquals(LocalDate.of(2022,4,1), expireDate);
}
```