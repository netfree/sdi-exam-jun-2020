package ro.ubb.exam.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.exam.common.SensorService;
import ro.ubb.exam.common.model.Sensor;
import ro.ubb.exam.server.repository.SensorRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SensorServiceImpl implements SensorService {
    private ExecutorService executorService;

    @Autowired
    SensorRepository sensorRepository;


    public SensorServiceImpl(ExecutorService executorService){
        this.executorService = executorService;
    }

    @Override
    public Future<Boolean> addSensorData(Sensor sensor) {
        return executorService.submit(() -> {
            System.out.println("added sensor " + sensor.toString());
            sensorRepository.save(sensor);
            return true;
        });
    }
}
