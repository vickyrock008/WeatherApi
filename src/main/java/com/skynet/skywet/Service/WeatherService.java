package com.skynet.skywet.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.skynet.skywet.Data.WeatherData;
import org.springframework.stereotype.Component;

@Component
public interface WeatherService {
    String getWeatherData(WeatherData weatherData) throws JsonProcessingException;

}
