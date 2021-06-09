package ro.ubb.exam.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.exam.core.model.SensorData;
import ro.ubb.exam.core.repository.SensorDataRepository;

import java.util.List;

@Service
public class SensorDataServiceImpl implements SensorDataService {
    @Autowired
    SensorDataRepository sensorDataRepository;

    @Override
    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }
}
