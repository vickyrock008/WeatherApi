package com.skynet.skywet.API;

import com.skynet.skywet.Data.WeatherData;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Component
public class WeatherApiClient {
    private final WebClient webClient;
    private String yourApiKey;

    public WeatherApiClient(WebClient.Builder webClientBuilder,@Value("${api.key}") String yourApiKey) {
        this.webClient = webClientBuilder.clientConnector(new ReactorClientHttpConnector(
                HttpClient.create()
                        .resolver(DefaultAddressResolverGroup.INSTANCE) // Forces IPv4
        )).baseUrl("https://api.openweathermap.org/data/2.5/weather").build();
        this.yourApiKey = yourApiKey;
    }
    public String getWeatherDataByCity(WeatherData weatherData) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("zip", weatherData.getPincode()+",In")
                        .queryParam("appid", yourApiKey)
                        .queryParam("units", "metric")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
