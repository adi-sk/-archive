import java.time.LocalTime;

public class HelloWorld2 {

	private LocalTime time;

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	/*public HelloWorld2(LocalTime time) {
		this.time = time;
	}*/

	public String helloBolo(String name) {
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
