package com.rubber_duck.RestService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubber_duck.RestService.model.Device;
import com.rubber_duck.RestService.repository.DeviceRepository;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device getDevice(String name) {
        return deviceRepository.findAllByName(name);
    }

    public List<Device> listDevice() {
        return deviceRepository.findAll();
    }
}
