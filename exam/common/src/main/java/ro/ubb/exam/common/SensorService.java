package ro.ubb.exam.common;

import ro.ubb.exam.common.model.Sensor;

import java.util.concurrent.Future;

public interface SensorService {
    int PORT = 1234;
    String host = "localhost";

    Future<Boolean> addSensorData(Sensor sensor);
}
