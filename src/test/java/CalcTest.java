import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest {
	private static int monthPay;
	private static int overPay;
	private static final int sum = 500000;
	private static final int months = 24;
	private static final int rates = 12;

	private static final Calc credit = new Calc();

	@BeforeAll
	public static void createTestData() {
		monthPay = credit.getMonthlyPay(sum, months, rates);
		overPay = credit.getOverpayAmount(monthPay, months, sum);
	}

	@Test
	public void TestGetMonthlyPay() {
		final int expected = 23537;
		int result = credit.getMonthlyPay(sum, months, rates);
		Assertions.assertEquals(expected, result);
	}

	@Test
	public void TestGetOverpayAmount() {
		final int expected = 64888;
		int result = credit.getOverpayAmount(monthPay, months, sum);
		Assertions.assertEquals(expected, result);
	}

	@Test
	public void TestGetTotalPay() {
		final int expected = 564888;
		int result = credit.getTotalPay(sum, overPay);
		Assertions.assertEquals(expected, result);
	}
}
