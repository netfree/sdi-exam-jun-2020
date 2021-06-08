package ro.ubb.exam.server.service;

import ro.ubb.exam.common.SensorService;
import ro.ubb.exam.common.model.Sensor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SensorServiceImpl implements SensorService {
    private ExecutorService executorService;


    public SensorServiceImpl(ExecutorService executorService){
        this.executorService = executorService;
    }

    @Override
    public Future<Boolean> addSensorData(Sensor sensor) {
        return executorService.submit(() -> {
            System.out.println("added sensor " + sensor.toString());
            return true;
        });
    }
}
