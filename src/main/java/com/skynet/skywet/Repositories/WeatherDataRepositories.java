package com.skynet.skywet.Repositories;

import com.skynet.skywet.Data.WeatherData;
import com.skynet.skywet.Entities.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepositories extends JpaRepository<WeatherEntity, Long> {

}
