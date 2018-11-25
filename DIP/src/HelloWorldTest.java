import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void testHelloWorldSaysHello() {
		HelloWorld hw = new HelloWorld();
		String actualResult = hw.helloBolo("Majrul");
		String expectedResult = "Hello, Good Afternoon Majrul";
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testHelloWorld2SaysHello() {
		LocalTime time = LocalTime.of(21, 30);
		HelloWorld2 hw = new HelloWorld2();
		hw.setTime(time);
		String actualResult = hw.helloBolo("Majrul");
		String expectedResult = "Hello, Shabba Khair Majrul";
		assertEquals(expectedResult, actualResult);

		time = LocalTime.of(4, 30);
		hw = new HelloWorld2();
		hw.setTime(time);
		actualResult = hw.helloBolo("Majrul");
		expectedResult = "Hello, Good Morning Majrul";
		assertEquals(expectedResult, actualResult);

	}

}
