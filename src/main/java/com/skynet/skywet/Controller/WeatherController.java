package com.skynet.skywet.Controller;

import com.skynet.skywet.Data.WeatherData;
import com.skynet.skywet.Service.WeatherDataService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
private final WeatherDataService weatherDataService;

    public WeatherController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }
    @RequestMapping("/")
    public String getSessionID(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return "Session ID: " + sessionId;

    }
    @PostMapping("/get")
    public String getWeather(@RequestBody WeatherData weatherData) throws Exception {
        return this.weatherDataService.getWeatherData(weatherData);
    }
}
