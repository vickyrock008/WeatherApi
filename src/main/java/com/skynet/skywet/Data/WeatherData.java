package com.skynet.skywet.Data;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
public class WeatherData {
    private LocalDate date;
    private String pincode;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
