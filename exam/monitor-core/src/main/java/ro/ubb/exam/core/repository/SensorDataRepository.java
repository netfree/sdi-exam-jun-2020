package ro.ubb.exam.core.repository;

import org.springframework.data.jpa.repository.Query;
import ro.ubb.exam.core.model.SensorData;

import java.util.List;

public interface SensorDataRepository extends Repository<Long, SensorData> {
    List<SensorData> findTop4ByNameOrderByTimestampDesc(String name);

    @Query(value = "select distinct name from sensors", nativeQuery = true)
    public List<String> getSensorNames();
}
