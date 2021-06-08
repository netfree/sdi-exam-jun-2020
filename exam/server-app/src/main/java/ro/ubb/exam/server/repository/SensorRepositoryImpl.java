package ro.ubb.exam.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.exam.common.model.Sensor;

import java.util.List;

public class SensorRepositoryImpl implements SensorRepository {
    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Sensor> findAll() {
        String sql = "select * from sensors";
        return jdbcOperations.query(sql, (rs, i) -> {
            String name = rs.getString("name");
            int id = rs.getInt("id");
            int measurement = rs.getInt("measurement");
            return new Sensor(name, id, measurement);
        });


    }

    @Override
    public void save(Sensor sensor) {
        String sql = "insert into sensors (name, measurement) values (?,?)";
        jdbcOperations.update(sql, sensor.getName(), sensor.getMeasurement());
    }
}
