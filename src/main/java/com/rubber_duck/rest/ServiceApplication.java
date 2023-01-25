package com.rubber_duck.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.rubber_duck.rest.repository.AlarmRepository;
import com.rubber_duck.rest.repository.DeviceRepository;
import com.rubber_duck.rest.repository.MoodRepository;
import com.rubber_duck.rest.repository.MotionRepository;
import com.rubber_duck.rest.repository.NetworkRepository;
import com.rubber_duck.rest.repository.TemperatureRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {
	AlarmRepository.class,
	MoodRepository.class,
	DeviceRepository.class,
	MotionRepository.class,
	NetworkRepository.class,
	TemperatureRepository.class
})
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}
