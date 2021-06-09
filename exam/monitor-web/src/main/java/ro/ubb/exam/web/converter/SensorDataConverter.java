package ro.ubb.exam.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.exam.core.model.SensorData;
import ro.ubb.exam.web.dto.SensorDataDto;
import ro.ubb.exam.web.dto.SensorsDataDto;

@Component
public class SensorDataConverter extends BaseConverter<SensorData, SensorDataDto>{
    @Override
    public SensorData convertDtoToModel(SensorDataDto dto) {
        var sensorData = new SensorData();
        sensorData.setId(dto.getId());
        sensorData.setMeasurement(dto.getMeasurement());
        sensorData.setTimestamp(dto.getTimestamp());
        sensorData.setName(dto.getName());
        return sensorData;
    }

    @Override
    public SensorDataDto convertModelToDto(SensorData sensorData) {
        SensorDataDto dto = new SensorDataDto();
        dto.setId(sensorData.getId());
        dto.setId(sensorData.getId());
        dto.setMeasurement(sensorData.getMeasurement());
        dto.setTimestamp(sensorData.getTimestamp());
        dto.setName(sensorData.getName());
        return dto;
    }
}
