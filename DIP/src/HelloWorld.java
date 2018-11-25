import java.time.LocalTime;

public class HelloWorld {

	public String helloBolo(String name) {
		LocalTime time = LocalTime.now();
		if(time.getHour() < 12)
			return "Hello, Good Morning " + name;
		else if(time.getHour() < 16)
			return "Hello, Good Afternoon " + name;
		else if(time.getHour() < 21)
			return "Hello, Good Evening " + name;
		else
			return "Hello, Shabba Khair " + name;
	}
}
