package com.skynet.skywet.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import java.time.LocalDate;

@Entity
@Table(name = "weather_data")

public class WeatherEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "location", nullable = false)
        private String location;
        @Column(name = "temperature", nullable = false)
        private double temperature;
        @Column(name = "humidity", nullable = false)
        private int humidity;
        @Column(name = "pressure", nullable = false)
        private int pressure;
        @Column(name = "weathercondition", nullable = false)
        private String weathercondition;
        @Column(name = "wind_speed", nullable = false)
        private double windSpeed;
        @Column(name = "date", nullable = false)
        private LocalDate date;
        @Column(name = "pincode", nullable = false)
        private String pincode;

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public String getweatherCondition() {
        return weathercondition;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPincode() {
        return pincode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setweatherCondition(String weathercondition) {
        this.weathercondition = weathercondition;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
