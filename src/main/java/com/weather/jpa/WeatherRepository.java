package com.weather.jpa;

import com.weather.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long>, CrudRepository< Weather, Long> {

    List<Weather> findAllByUser(@Param("user") String user);
    List<Weather> findAllByPostalCode(@Param("postalCode") String postalCode);
    List<Weather> findAllByPostalCodeAndUser(@Param("postalCode") String postalCode, @Param("user") String user);

}
