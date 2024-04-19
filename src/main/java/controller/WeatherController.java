package controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import service.WeatherServiceImpl;

@Controller
@RequestMapping("/weather")
public class WeatherController {
    private static final Log APP_LOG = LogFactory.getLog(WeatherController.class);
    @Autowired
    WeatherServiceImpl weatherService;

    @PostMapping("/forecast_summary")
    public String getWeatherforecastsummaryDetails() {
        try {
            String response;
            WeatherServiceImpl s = new WeatherServiceImpl();
            response = s.getWeatherApiDetails();
            APP_LOG.info("response" + response);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/hourly_forecast")
    public String gethourlyWeatherforecastDetails() {
        try {
            String response;
            WeatherServiceImpl s = new WeatherServiceImpl();
            response = s.gethourlyWeatherforecastDetails();
            APP_LOG.info("response" + response);

            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
