package service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherServiceImpl implements WeatherService{
    private static final Log APP_LOG = LogFactory.getLog(WeatherServiceImpl.class);
    @Override
    public String getWeatherApiDetails() {

        System.out.println("getWeatherApiDetails");
        ResponseEntity<String> responseEntity = null;
        String response = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            String  basicurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/summary/";
            headers.set("X-RapidAPI-Key", "25fdc2aa82mshe9e5bb813b306d4p1edf3cjsna21a6f66150e");
            headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");

            final HttpEntity<?> entity = new HttpEntity<>(headers);
            responseEntity = restTemplate.exchange(basicurl, HttpMethod.GET, entity, String.class);
            response = responseEntity.getBody();

        } catch (HttpServerErrorException | HttpClientErrorException e) {
            e.printStackTrace();
            System.out.println("HttpServerErrorException");
            APP_LOG.error("HttpServerErrorException | HttpClientErrorException " + ", error: " + e.getResponseBodyAsString());
        } catch (RestClientException e) {
            e.printStackTrace();
            APP_LOG.error("RestClientException", e);

        } catch (Exception e) {
            e.printStackTrace();
            APP_LOG.error("Error while getting Rapid Api Get Forecast Summary By Location Name", e);

        }
        return  response;
    }

    public String gethourlyWeatherforecastDetails() {
        System.out.println("getWeatherApiDetails");
        ResponseEntity<String> responseEntity = null;
        String response = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            String  basicurl = "https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/hourly/";
            headers.set("X-RapidAPI-Key", "25fdc2aa82mshe9e5bb813b306d4p1edf3cjsna21a6f66150e");
            headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");

            final HttpEntity<?> entity = new HttpEntity<>(headers);
            responseEntity = restTemplate.exchange(basicurl, HttpMethod.GET, entity, String.class);
            response = responseEntity.getBody();

        } catch (HttpServerErrorException | HttpClientErrorException e) {
            e.printStackTrace();
            System.out.println("HttpServerErrorException");
            APP_LOG.error("HttpServerErrorException | HttpClientErrorException " + ", error: " + e.getResponseBodyAsString());
        } catch (RestClientException e) {
            e.printStackTrace();
            APP_LOG.error("RestClientException", e);

        } catch (Exception e) {
            e.printStackTrace();
            APP_LOG.error("Error while getting Rapid Api Get Hourly Forecast Summary By Location Name", e);

        }
        return  response;
    }
}





