package dice.tech.weather;

import controller.WeatherController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="dice.tech")
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
//		System.out.println("---- APP RUNNING ----");
//		String weatherController = new WeatherController().gethourlyWeatherforecastDetails();
//		System.out.println("RESPONE ");
//		System.out.println(weatherController);
	}


}
