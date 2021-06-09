package ro.ubb.exam.core.service;

import ro.ubb.exam.core.model.SensorData;

import java.util.List;

public interface SensorDataService {
    List<SensorData> getAllSensorData();
    List<SensorData> getMostRecent4(String name);
    List<String> getSensorNames();
}
