package ro.ubb.exam.server.repository;

import ro.ubb.exam.common.model.Sensor;

import java.util.List;

public interface SensorRepository {
    List<Sensor> findAll();

    void save(Sensor student);
}
