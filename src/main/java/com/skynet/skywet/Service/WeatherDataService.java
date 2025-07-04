package com.skynet.skywet.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skynet.skywet.API.WeatherApiClient;
import com.skynet.skywet.Data.WeatherData;
import com.skynet.skywet.Entities.WeatherEntity;
import com.skynet.skywet.Repositories.WeatherDataRepositories;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataService implements WeatherService {
private final WeatherDataRepositories weatherDataRepositories;
private final WeatherApiClient weatherApiClient;

     public WeatherDataService(WeatherDataRepositories weatherDataRepositories,
                               WeatherApiClient weatherApiClient) {
        this.weatherDataRepositories = weatherDataRepositories;
        this.weatherApiClient = weatherApiClient;
    }
    @Override
    public String getWeatherData(WeatherData weatherData) throws JsonProcessingException {
        String response = this.weatherApiClient.getWeatherDataByCity(weatherData);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setDate(weatherData.getDate());
        weatherEntity.setPincode(weatherData.getPincode());
        weatherEntity.setweatherCondition(jsonNode.path("weather").get(0).path("description").asText());
        weatherEntity.setTemperature(jsonNode.path("main").path("temp").asDouble());
        weatherEntity.setHumidity(jsonNode.path("main").path("humidity").asInt());
        weatherEntity.setPressure(jsonNode.path("main").path("pressure").asInt());
        weatherEntity.setWindSpeed(jsonNode.path("wind").path("speed").asDouble());
        weatherEntity.setLocation(jsonNode.path("name").asText());
        weatherDataRepositories.save(weatherEntity);
        return response;
    }
}
